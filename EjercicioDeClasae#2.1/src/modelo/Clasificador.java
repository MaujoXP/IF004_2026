/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public class Clasificador {
    public String clasificacion(int n) {
        String tipo = "";
        int suma = 0;
        
        for(int i = n - 1; i > 0; i--) {
            if(n % i == 0) {
                suma += i;
            }
        }
        if(suma < n) {
            tipo = "Deficiente";
        } else if(suma == n) {
            tipo = "Perfecto";
        } else {
            tipo = "Abundante";
        }
  
        return tipo;
    }
}
