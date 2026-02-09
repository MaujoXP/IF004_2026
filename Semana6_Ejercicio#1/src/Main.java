/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaby
 */
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = null;
        try {
            cuenta = new CuentaBancaria("Mauricio", 1000);
            System.out.println("Cuenta creada para: " + cuenta.getTitular());
            System.out.println("Saldo inicial: " + cuenta.getSaldo());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear la cuenta" + e.getMessage());
        } finally {
            System.out.println("[Finally] Finalizó intento de creación de cuenta.\n");
        }
        
        if(cuenta == null) {
            System.out.println("No se puede continuar sin una cuenta válida");
            return;
        }
        
        try {
            cuenta.depositar(200);
            System.out.println("Deposito exitoso. Saldo actual: " + cuenta.getSaldo());
        } catch(IllegalArgumentException e) {
            System.out.println("Error en depósito: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Finalizó operación de depósito");
        }
        
        try {
            cuenta.retirar(200);
            System.out.println("Retiro exitoso. Saldo actual: " + cuenta.getSaldo());
        } catch(IllegalArgumentException e) {
            System.out.println("Error en retiro: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Finalizó operación de retiro");
        }
        
        System.out.println("Programa finalizado");
    }
}
