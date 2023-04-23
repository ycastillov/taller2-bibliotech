/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.pa.bibliotech.services;

import cl.ucn.disc.pa.bibliotech.model.Libro;
import cl.ucn.disc.pa.bibliotech.model.Socio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.princeton.cs.stdlib.StdOut;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Sistema.
 *
 * @author Programacion Avanzada.
 */
public final class Sistema {

    /**
     * Procesador de JSON.
     */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * The list of Socios.
     */
    private Socio[] socios;

    /**
     * The list of Libros.
     */
    private Libro[] libros;

    /**
     * Socio en el sistema.
     */
    private Socio socio;

    /**
     * The Sistema.
     */
    public Sistema() throws IOException {

        // no hay socio logeado.
        this.socios = new Socio[0];
        this.libros = new Libro[0];
        this.socio = null;

        // carga de los socios y libros.
        try {
            this.cargarInformacion();
        } catch (FileNotFoundException ex) {
            // no se encontraron datos, se agregar los por defecto.

            // creo un socio
            this.socios = Utils.append(this.socios, new Socio("John", "Doe", "john.doe@ucn.cl", 1, "john123"));

            // creo un libro y lo agrego al arreglo de libros.
            this.libros = Utils.append(this.libros, new Libro("1491910771", "Head First Java: A Brain-Friendly Guide", " Kathy Sierra", "Programming Languages", 5));

            // creo otro libro y lo agrego al arreglo de libros.
            this.libros = Utils.append(this.libros, new Libro("1491910771", "Effective Java", "Joshua Bloch", "Programming Languages", 4));

        } finally {
            // guardo la informacion.
            this.guardarInformacion();
        }

    }

    /**
     * Activa (inicia sesion) de un socio en el sistema.
     *
     * @param numeroDeSocio a utilizar.
     * @param contrasenia   a validar.
     */
    public void iniciarSession(final int numeroDeSocio, final String contrasenia) {

        // el numero de socio siempre es positivo.
        if (numeroDeSocio <= 0) {
            throw new IllegalArgumentException("El numero de socio no es valido!");
        }

        Socio socio = this.buscarSocio(numeroDeSocio);

        if (socio == null) {
            throw new IllegalArgumentException("El socio con numero " + numeroDeSocio + " no existe o no se encuentra disponible.");
        }

        Socio socioContrasenia = this.validarContrasenia(contrasenia);

        if (socioContrasenia == null) {
            throw new IllegalArgumentException("La clave es incorrecta.");
        }

        this.socio = socio;

    }

    /**
     * Cierra la session del Socio.
     */
    public void cerrarSession() {
        this.socio = null;
    }

    /**
     * Metodo que mueve un libro de los disponibles y lo ingresa a un Socio.
     *
     * @param isbn del libro a prestar.
     */
    public void realizarPrestamoLibro(final String isbn) throws IOException {
        // el socio debe estar activo.
        if (this.socio == null) {
            throw new IllegalArgumentException("Socio no se ha logeado!");
        }

        // busco el libro.
        Libro libro = this.buscarLibro(isbn);

        // si no lo encontre, lo informo.
        if (libro == null) {
            throw new IllegalArgumentException("Libro con isbn " + isbn + " no existe o no se encuentra disponible.");
        }

        // agrego el libro al socio.
        this.socio.agregarLibro(libro);

        // TODO: eliminar el libro de los disponibles // Listo

        Libro eliminar = this.eliminarLibro(libro);

        if (eliminar == null) {
            throw new IllegalArgumentException("No se encuentra el libro con isbn " + isbn + " dentro de la lista de libros disponibles.");
        }

        // se actualiza la informacion de los archivos
        this.guardarInformacion();

    }


    /**
     * Obtiene un String que representa el listado completo de libros disponibles.
     *
     * @return the String con la informacion de los libros disponibles.
     */
    public String obtegerCatalogoLibros() {

        StringBuilder sb = new StringBuilder();
        try {
            for (Libro libro : this.libros) {
                sb.append("Titulo    : ").append(libro.getTitulo()).append("\n");
                sb.append("Autor     : ").append(libro.getAutor()).append("\n");
                sb.append("ISBN      : ").append(libro.getIsbn()).append("\n");
                sb.append("Categoria : ").append(libro.getCategoria()).append("\n");
                sb.append("Calificacion : ").append(libro.getCalificacion()).append("\n");
                sb.append("\n");
            }
        } catch (NullPointerException e) {
            StdOut.print("No hay libros disponibles.");
        }

        return sb.toString();
    }


    /**
     * Metodo que busca un libro en los libros disponibles.
     *
     * @param isbn a buscar.
     * @return el libro o null si no fue encontrado.
     */
    private Libro buscarLibro(final String isbn) {
        // recorro el arreglo de libros.
        for (Libro libro : this.libros) {
            // si lo encontre, retorno el libro.
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        // no lo encontre, retorno null.
        return null;
    }

    private Libro eliminarLibro(final Libro libro) {
        StdOut.print(this.libros);
        for (Libro eliminar : this.libros) {
            if (eliminar.equals(libro)) {
                this.libros = null;
                return eliminar;
            }
        }

        return null;
    }

    /**
     * Lee los archivos libros.json y socios.json.
     *
     * @throws FileNotFoundException si alguno de los archivos no se encuentra.
     */
    private void cargarInformacion() throws FileNotFoundException {

        // trato de leer los socios y los libros desde el archivo.
        this.socios = GSON.fromJson(new FileReader("socios.json"), Socio[].class);
        this.libros = GSON.fromJson(new FileReader("libros.json"), Libro[].class);
    }

    /**
     * Guarda los arreglos libros y socios en los archivos libros.json y socios.json.
     *
     * @throws IOException en caso de algun error.
     */
    private void guardarInformacion() throws IOException {

        // guardo los socios.
        try (FileWriter writer = new FileWriter("socios.json")) {
            GSON.toJson(this.socios, writer);
        }

        // guardo los libros.
        try (FileWriter writer = new FileWriter("libros.json")) {
            GSON.toJson(this.libros, writer);
        }

    }

    public String obtenerDatosSocioLogeado() {
        if (this.socio == null) {
            throw new IllegalArgumentException("No hay un Socio logeado");
        }

        return "Nombre: " + this.socio.getNombreCompleto() + "\n"
                + "Correo Electronico: " + this.socio.getCorreoElectronico();

    }

    private Socio buscarSocio(final int numeroDeSocio) {
        for (Socio socio : this.socios) {
            if (socio.getNumeroDeSocio() == numeroDeSocio) {
                return socio;
            }
        }
        return null;
    }

    private Socio validarContrasenia(final String contrasenia) {
        for (Socio socioContrasenia : this.socios) {
            if (socioContrasenia.getContrasenia().equals(contrasenia)) {
                return socioContrasenia;
            }
        }
        return null;
    }

    public Socio cambiarContrasenia(final String contrasenia) {
        if (contrasenia == null || contrasenia.length() == 0) {
            throw new IllegalArgumentException("Contraseña no valida.");
        }
        this.socio.setContrasenia(contrasenia);
        return null;
    }

    public Socio cambiarCorreoElectronico(final String correoElectronico) {
        Utils.validarEmail(correoElectronico);
        this.socio.setCorreoElectronico(correoElectronico);
        return null;
    }

    public void calificarLibro(final int calificacion) {
        if (calificacion > 5 & calificacion < 0) {

        }
    }


}
