/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Libro {
    private String titulo = "";
    private String autor = "";
    private int numeroPaginas = 0;
    private double precio = 0;
    private int anioPublicacion = 0;

    public Libro() {
        this.titulo = "Libro genérico";
        this.autor = "Sin autor";
        this.numeroPaginas = 50;
        this.precio = 5000;
        this.anioPublicacion = 2026;
    }
    
    public Libro(String titulo, String autor, int numeroPaginas, double precio, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
    }
    
    /**
    * Calcula el monto correspondiente a un descuento basado en un porcentaje.
    *
    * @param descuento porcentaje de descuento (0-100)
    * @return el monto descontado aplicado al precio del libro
    */
    public double calcularDescuento(int descuento) {
        double descuentoPorcentual = descuento / 100.0;
        return this.precio * descuentoPorcentual; 
    }
    
    /**
    * Verifica si el libro es considerado antiguo.
    * Actualmente se considera antiguo si tiene más de 10 años desde su publicación.
    *
    * @return true si el libro es antiguo, false en caso contrario
    */
    public boolean esAntiguo() {
        return (2026 - this.anioPublicacion) > 10;
    }
    
    /**
    * Verifica si el libro es considerado antiguo.
    * Actualmente se considera antiguo si tiene más de 10 años desde su publicación.
    *
    * @return true si el libro es antiguo, false en caso contrario
    */
    public boolean esCaro(double precio) {
        return precio < this.precio;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    @Override
    public String toString() {
        String msg = "";
        msg += "Título: " + this.titulo +
                "\nAutor: " + this.autor +
                "\nCantidad de páginas: " + this.numeroPaginas +
                "\nPrecio: " + this.precio +
                "\nAño de publicación: " + this.anioPublicacion;
        return msg;
    }
    
    
    
    
}
