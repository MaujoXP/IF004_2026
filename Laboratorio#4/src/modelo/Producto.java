/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gaby
 */
public class Producto {
    private int codigo;
    private String nombreProducto;
    private double precioUnitario;
    private int stock;
    
    public Producto(int codigo, String nombreProducto, double precioUnitario, int stock) {
        setCodigo(codigo);
        setNombreProducto(nombreProducto);
        setPrecioUnitario(precioUnitario);
        setStock(stock);
    }
    
    public void agregarStock(int stock) throws IllegalArgumentException {
        if(stock <= 0) {
            throw new IllegalArgumentException("Para agregar stock debe agregar almenos 1 producto");
        } else {
            this.stock += stock;
        }
    }
    
    public void restarStock(int stock) {
        if() {
            throw new IllegalArgumentException();
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(int codigo) {
        if(codigo <= 0) {
            throw new IllegalArgumentException("Código de producto debe ser mayor a 0");
        } else {
            this.codigo = codigo;
        }
    }

    public void setNombreProducto(String nombreProducto) {
        if(nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre del producto no debe estar en blanco");
        } else {
            this.nombreProducto = nombreProducto;
        }
    }

    public void setPrecioUnitario(double precioUnitario)throws IllegalArgumentException{
        if(precioUnitario <= 0) {
            throw  new IllegalArgumentException("Precio unitario debe ser mayor a 0");
        } else {
            this.precioUnitario = precioUnitario;
        }
    }

    public void setStock(int stock) throws IllegalArgumentException{
        if(stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        } else {
            this.stock = stock;
        }
    }
}
