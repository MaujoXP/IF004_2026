/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaarchivotexto;
import java.io.*;
/**
 *
 * @author Gaby
 */
public class JavaArchivoTexto {

    File archivo = new File("Calificaciones.txt");
    
    private void crearArchivoTexto() {
        try {
            if(archivo.createNewFile()) {
                System.out.println("Archivo creado con exito");
            } else {
                System.out.println("Archivo ya existe");
            }
        } catch(IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    private void eliminarArchivoTexto() {
        if(archivo.delete()) {
            System.out.println("El archivo fue eliminado exitosamente");
        } else {
            System.out.println("Error al eliminar archivo");
        }
    }
    
    private void escribirArchivo() {
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write("Tengo altas expectativas para el Parcial 2");
            escribir.close();
            System.out.println("Texto agregado correctamente");
        } catch(IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    private void leerArchivoTexto() {
        try {
            String mensaje;
            FileReader leer = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(leer);
            mensaje = lector.readLine();
            System.out.println(mensaje);
        } catch(IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void main(String[] args) {
        JavaArchivoTexto archivoTxT = new JavaArchivoTexto();
        archivoTxT.crearArchivoTexto();
        archivoTxT.escribirArchivo();
        archivoTxT.leerArchivoTexto();
        //archivoTxT.eliminarArchivoTexto();
    }
}
