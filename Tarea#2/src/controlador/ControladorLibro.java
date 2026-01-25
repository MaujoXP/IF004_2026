/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Libro;
import vista.VistaLibro;

/**
 *
 * @author Meowricio
 */
public class ControladorLibro {
    private Libro modelo;
    private VistaLibro vista;
    
    public ControladorLibro(Libro modelo, VistaLibro vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void menuInicio() {
        int opcion = vista.opcionMenu();
        String msg = "";
        String titulo;
        String autor;
        int numP;
        double precio;
        int anioP;
        int opcionModificar;
        
        switch (opcion) {
            case 1:
                titulo = vista.pedirString();
                autor = vista.pedirString();
                numP = vista.pedirInt();
                precio = vista.pedirDouble();
                anioP = vista.pedirInt();
                Libro nuevoLibro = new Libro(titulo, autor, numP, precio, anioP);
                this.modelo = nuevoLibro;
                msg = "Libro creado\n\n" + this.modelo.toString();
                vista.mostrarEvento(msg);
                menuInicio();
                break;
            case 2:
                msg = "Información del libro\n\n" + this.modelo.toString();
                vista.mostrarEvento(msg);
                menuInicio();
                break;
            case 3:
                msg = "Título del libro: " + modelo.getTitulo();
                vista.mostrarEvento(msg);
                opcionModificar = vista.eleccionUsuario("titulo");

                if(validarOpcion(opcionModificar)) {
                    titulo = vista.pedirString();
                    modelo.setTitulo(titulo);
                    msg = "Titulo cambiado exitosamente";
                    vista.mostrarEvento(msg);
                }
                
                menuInicio();
                break;
            case 4:
                msg = "Autor del libro: " + modelo.getAutor();
                vista.mostrarEvento(msg);
                opcionModificar = vista.eleccionUsuario("autor");
                
                if(validarOpcion(opcionModificar)) {
                    autor = vista.pedirString();
                    modelo.setAutor(autor);
                    msg = "Autor cambiado exitosamente";
                    vista.mostrarEvento(msg);
                }
                
                menuInicio();
                break;
            case 5:
                msg = "Número de páginas del libro: " + modelo.getNumeroPaginas();
                vista.mostrarEvento(msg);
                opcionModificar = vista.eleccionUsuario("número de paginas");
                
                if(validarOpcion(opcionModificar)) {
                    numP = vista.pedirInt();
                    modelo.setNumeroPaginas(numP);
                    msg = "Número de páginas cambiado exitosamente";
                    vista.mostrarEvento(msg);
                }
                
                menuInicio();
                break;
            case 6: 
                msg = "Precio del libro: " + modelo.getPrecio();
                vista.mostrarEvento(msg);
                opcionModificar = vista.eleccionUsuario("precio");
                
                if(validarOpcion(opcionModificar)) {
                    precio = vista.pedirDouble();
                    modelo.setPrecio(precio);
                    msg = "Precio cambiado exitosamente";
                    vista.mostrarEvento(msg);
                }
                
                menuInicio();
                break;
            case 7:
                msg = "Año de publicación del libro: " + modelo.getAnioPublicacion();
                vista.mostrarEvento(msg);
                opcionModificar = vista.eleccionUsuario("año de publicación");
                
                if(validarOpcion(opcionModificar)) {
                    anioP = vista.pedirInt();
                    modelo.setAnioPublicacion(anioP);
                    msg = "Año de publicación cambiado exitosamente";
                    vista.mostrarEvento(msg);
                }
                
                menuInicio();
                break;
            case 8:
                msg = "Debe ingresar el descuento que se le realizará sobre el libro";
                vista.mostrarEvento(msg);
                int descuentoBase = vista.pedirInt();
                double descuento = modelo.calcularDescuento(descuentoBase);
                msg = "El precio del libro es: " + modelo.getPrecio() 
                        + "\nSe le aplicó un descuento de: " + descuento
                        + "\nEl precio con el descuento aplicado seria de: " + (modelo.getPrecio() - descuento);
                
                vista.mostrarEvento(msg);
                menuInicio();
                break;
            case 9:
                msg = "Se calculará si el libro es antiguo sí fue publicado hace más de 10 años";
                vista.mostrarEvento(msg);
                
                if(modelo.esAntiguo()) {
                    msg = "Es un libro antiguo";
                } else {
                    msg = "No es un libro antiguo";
                }
                
                vista.mostrarEvento(msg);
                menuInicio();
                break;
            case 10:
                msg = "Se calculará si el libro es muy caro según su presupuesto ingresado";
                vista.mostrarEvento(msg);
                double presupuesto = vista.pedirDouble();
                
                if(modelo.esCaro(presupuesto)) {
                    msg = "Es un libro caro para su presupuesto";
                } else {
                    msg = "No es un libro caro para su presupuesto";
                }
                
                vista.mostrarEvento(msg);
                menuInicio();
                break;
            case 11:
                break;
            default:
                menuInicio();
                break;
        }
    }
    
    private boolean validarOpcion(int opcion) {
        return opcion == JOptionPane.YES_OPTION;
    }
}
