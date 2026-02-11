/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaby
 */
public class CuentaBancaria {
    private String titular;
    private double saldo;
    
    /**Constructor de la clase CuentaBancaria
     * @param titular nombre del titular
     * @param saldoInicial saldo con el que inicia la cuenta
     * @throws IllegalArgumentException si titular es vacío o saldo inicial es negativo
    */
    public CuentaBancaria(String titular, double saldoInicial) throws IllegalArgumentException {
        if(titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede estar vacío");
        }
        if(saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    public void depositar(double monto) throws IllegalArgumentException{
        if(monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero");
        }
        saldo += monto;
    }
    
    public void retirar(double monto) throws IllegalArgumentException{
        if(monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero");
        }
        if(monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes para realizar el retiro");
        }
        
        saldo -= monto;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
