/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Scanner;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Persona;
import modelo.Producto;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("\n=====CREACION PERSONA=====");
            System.out.print("Nombre del cliente: ");
            String nombreCliente = sc.nextLine();

            System.out.print("Identificación: ");
            int idCliente;
            String StringIdCliente = sc.nextLine();
            if (StringIdCliente.trim().isEmpty()) {
                throw new IllegalArgumentException("La identificación no puede estar vacía");
            }

            idCliente = Integer.parseInt(StringIdCliente);

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            Cliente cliente = null;
            try {
                cliente = new Cliente(nombreCliente, idCliente, correo);
                System.out.println("Cliente creado correctamente.\n");
            } catch (RuntimeException e) {
                System.out.println("Error creando cliente: " + e.getMessage());
            }

            System.out.println("\n=====CREACION DE PRODUCTO=====");
            System.out.print("Código: ");
            int codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre del producto: ");
            String nombreProducto = sc.nextLine();

            System.out.print("Precio unitario: ");
            double precio = sc.nextDouble();

            System.out.print("Stock inicial: ");
            int stock = sc.nextInt();

            Producto producto = null;
            try {
                producto = new Producto(codigo, nombreProducto, precio, stock);
                System.out.println("Producto creado correctamente.\n");
            } catch (RuntimeException e) {
                System.out.println("Error creando producto: " + e.getMessage());
            }

            System.out.println("\n=====CREACION DE PEDIDO=====");

            System.out.print("Cantidad solicitada: ");
            int cantidad = sc.nextInt();

            Pedido pedido = null;
            try {
                pedido = new Pedido(cliente, producto, cantidad);
                System.out.println("Pedido creado exitosamente.");
            } catch (RuntimeException e) {
                System.out.println("Error creando pedido: " + e.getMessage());
            }
            
        } catch(NumberFormatException e) {
            System.out.println("Error: debe ingresar un número entero válido.");
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(Exception ex) {
            System.out.println("\nError general capturado en main: " + ex.getMessage());
        } finally {
            System.out.println("\n=====FIN DEL PROGRAMA=====");
        }
    }
}
