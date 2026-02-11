/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Scanner;
import modelo.Moto;
import modelo.Vehiculo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Vehiculo carro = null;
        Moto moto = null;

        try {
            //Creación carro
            System.out.println("=====CREACIÓN CARRO=====");
            System.out.print("Marca del carro: ");
            String marcaCarro = sc.nextLine();

            System.out.print("Velocidad máxima del carro: ");
            int velCarro = Integer.parseInt(sc.nextLine());  
            carro = new Vehiculo(marcaCarro, velCarro);

            //Creación moto
            System.out.println("\n=====CREACIÓN MOTO=====");
            System.out.print("Marca de la moto: ");
            String marcaMoto = sc.nextLine();

            System.out.print("Velocidad máxima de la moto: ");
            int velMoto = Integer.parseInt(sc.nextLine());
            System.out.print("Cilindraje (cc): ");
            int cil = Integer.parseInt(sc.nextLine());
            moto = new Moto(marcaMoto, velMoto, cil);

            //Probar velocidad máxima posible
            System.out.print("\nIngrese una velocidad para probar el carro: ");
            int velPrueba = Integer.parseInt(sc.nextLine());
            carro.verificarVelocidad(velPrueba);

            //Poner marcha moto
            System.out.print("\nSeleccione una marcha (1-5): ");
            int marcha = Integer.parseInt(sc.nextLine());
            moto.seleccionarMarcha(marcha);

        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar números válidos.");

        } catch (NullPointerException e) {
            System.out.println("Dato vacío: " + e.getMessage());

        } catch (IllegalStateException e) {
            System.out.println("Valor inválido: " + e.getMessage());

        } catch (UnsupportedOperationException e) {
            System.out.println("Velocidad excedida: " + e.getMessage());

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Marcha inválida: " + e.getMessage());

        } finally {
            System.out.println("\n=====FIN DEL PROGRAMA=====");
            System.out.println("Vehículo creado: " + carro);
            System.out.println("Moto creada: " + moto);
        }
    }
}