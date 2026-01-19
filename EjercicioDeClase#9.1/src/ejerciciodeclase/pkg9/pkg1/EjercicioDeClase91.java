/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciodeclase.pkg9.pkg1;

/**
 *
 * @author Gaby
 */
public class EjercicioDeClase91 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String frase = "Hola mundo cruel";
        System.out.println(metodoUno(frase));
        System.out.println(metodoTres(frase));
        System.out.println(metodoCinco(frase));
    }

    public static String metodoUno(String frase) {
        String[] palabras = frase.split(" ");
        String palabraMayor = "";
        for (int i = 0; i < palabras.length; i++) {
            if (palabraMayor.length() < palabras[i].length()) {
                palabraMayor = palabras[i];
            }
        }

        return palabraMayor;
    }

    public static String metodoTres(String texto) {
        String resultado = "";
        texto = texto.toLowerCase();
        int[] vocales = new int[5];

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'a') {
                vocales[0]++;
            } else if (texto.charAt(i) == 'e') {
                vocales[1]++;
            } else if (texto.charAt(i) == 'i') {
                vocales[2]++;
            } else if (texto.charAt(i) == 'o') {
                vocales[3]++;
            } else if (texto.charAt(i) == 'u') {
                vocales[4]++;
            }
        }

        resultado += "a " + vocales[0] + " " + asteriscos(vocales[0]) + "\n";
        resultado += "e " + vocales[1] + " " + asteriscos(vocales[1]) + "\n";
        resultado += "i " + vocales[2] + " " + asteriscos(vocales[2]) + "\n";
        resultado += "o " + vocales[3] + " " + asteriscos(vocales[3]) + "\n";
        resultado += "u " + vocales[4] + " " + asteriscos(vocales[4]) + "\n";

        return resultado;
    }

    public static String metodoCinco(String frase) {
        String[] fragmento = frase.split(" ");
        String resultado = "";
        for (int i = 0; i < fragmento.length; i++) {
            resultado += fragmento[i].charAt(0);
        }

        return resultado.toUpperCase();
    }

    public static String asteriscos(int cantidad) {
        String resultado = "";
        for (int i = 0; i < cantidad; i++) {
            resultado += "*";
        }

        return resultado;
    }

    public static String retornarNum(String num) {
        String salida = "Ingrese 12 digitos incluyendo el codigo";

        String codigo = "(";
        String digitos = "";
        String digitos2 = "";

        if (num.length() == 11) {
            codigo += num.substring(0, 3) + ")-";
            digitos = num.substring(3, 7) + "-";
            digitos2 = num.substring(7, 11);
            salida = codigo + digitos + digitos2;
        }

        return salida;
    }

    public static boolean palindroma(String palabra) {
        palabra = palabra.toLowerCase();
        palabra = palabra.replace(" ", "");
        boolean esPalindroma = false;

        char inicio;
        char end;
        int indice = palabra.length() - 1;

        int contador = 0;

        for (int i = 0; i < palabra.length(); i++) {
            inicio = palabra.charAt(i);
            end = palabra.charAt(indice);

            if (inicio == end) {

                contador++;

            }
            indice--;

            if (contador == palabra.length()) {
                esPalindroma = true;
            }

        }

        return esPalindroma;
    }

}
