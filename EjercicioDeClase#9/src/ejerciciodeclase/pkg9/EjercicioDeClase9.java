/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciodeclase.pkg9;

/**
 *
 * @author Gaby
 */
public class EjercicioDeClase9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "Mauricio";
        String apellido = new String(" Bermúdez");
        
        //concatenar
        String nCompleto = nombre + apellido;
        System.out.println("El nombre es: " + nombre + " y el apellido: " + apellido);
        System.out.println("El nombre completo es: " + nCompleto);
        
        //Inmutabilidad
        String texto = "Hola";
        System.out.println("Texto original " + texto);
        texto = texto + " Mundo";
        System.out.println("Texto despues: " + texto);
        
        //Operaciones basicas
        System.out.println("La longitud de la cadena nombre: " + nombre.length());
        System.out.println("La longitud de la cadena apellido: " + apellido.length());
        System.out.println("Caracter en la posicion 5: " + nCompleto.charAt(5));
        
        //Comparar String
        String otroNombre = "mauricio bermúdez";
        System.out.println("Comparar nombre original " + nCompleto + " con otro nombre " + otroNombre );
        System.out.println("Equals " + nCompleto.equals(otroNombre));
        System.out.println("Ignore case " + nCompleto.equalsIgnoreCase(otroNombre));
        
        //Mayusculas o minusculas
        System.out.println("Texto mayusculas  " + nCompleto.toUpperCase());
        System.out.println("Texto minusculas " + nCompleto.toLowerCase());
        
        //Substring
        System.out.println("Saludo completo " + texto);
        System.out.println("Substring posicion 5 " + texto.substring(5));
        
        //Contiene, inicia o termina con
        System.out.println("Metodo contiene: " + texto.contains("Hola"));
        System.out.println("Metodo inicial: " + texto.startsWith("Hola"));
        System.out.println("Metodo termina: " + texto.endsWith("Hola"));
        
        //Trim
        String conEspacios = "   Hoy es Lunes   ";
        System.out.println("Cadena original: " + conEspacios);
        System.out.println("Cadena con Trim: " + conEspacios.trim());
        
        //toCharArray
        char[] letras = nCompleto.toCharArray();
        System.out.print("Los caracteres de la cadena son: "  );
        for(int i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + ", ");
        }
        System.out.println("");
        
        //Split
        String cursos = "IF1300;IF5000;IF3000;IF4100";
        System.out.println("Cadena antes: " + cursos);
        String[] partes = cursos.split(";");
        System.out.println("Cadena después: ");
        for(int i = 0; i < partes.length; i++) {
            System.out.println(partes[i] + ", ");
        }
        
        //Reemplazar
        System.out.println("Nombre original: " + nCompleto);
        String cambio = nCompleto.replace("Mauricio", "José");
        System.out.println("Nombre cambiado: " + cambio);
        
        //StringBuilder Crear
        StringBuilder sb = new StringBuilder("hola");
        System.out.println("Cadena original: " + sb);
        
        //Agregar caracteres Append
        sb.append(" Mauricio");
        System.out.println("Cadena despues de Append: " +  sb);
        
        //Insertar caracteres
        sb.insert(0, "Pura Vida, ");
        System.out.println("Cadena despues de insert: " + sb);
        
        //Delete
        sb.delete(0, 11);
        System.out.println("Cadena despues del delete: " + sb);
        
        //Reemplazar con replace
        sb.replace(0, 4, "adios");
        System.out.println("Cadena despues del replace: " + sb);
        
        //Invertir la cadena con reverse
        sb.reverse();
        System.out.println("Cadena inversa: " + sb);
        
        //Convertir a String
        String resultado = sb.toString();
        System.out.println("Cadena toString: " + resultado);
    }
    
}
