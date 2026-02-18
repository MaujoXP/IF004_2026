/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un producto disponible para venta, incluyendo su código,
 * nombre, precio unitario y cantidad en stock.
 * Permite aumentar o disminuir el inventario con validaciones de seguridad.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Producto {
    private int codigo;
    private String nombreProducto;
    private double precioUnitario;
    private int stock;
    
    /**
    * Crea un nuevo producto con su código, nombre, precio y stock inicial.
    *
    * @param codigo código único del producto, debe ser mayor a 0
    * @param nombreProducto nombre del producto, no puede estar en blanco
    * @param precioUnitario precio por unidad, debe ser mayor a 0
    * @param stock cantidad inicial disponible, debe ser mayor a 0
    * @throws IllegalArgumentException si algún parámetro no cumple las reglas
    */
    public Producto(int codigo, String nombreProducto, double precioUnitario, int stock) {
        setCodigo(codigo);
        setNombreProducto(nombreProducto);
        setPrecioUnitario(precioUnitario);
        setStock(stock);
    }
    
    /**
    * Aumenta el stock del producto.
    *
    * @param cantidad unidades a agregar, debe ser mayor a 0
    * @throws IllegalArgumentException si la cantidad no es válida
    */
    public void agregarStock(int cantidad) throws IllegalArgumentException {
        if(cantidad <= 0) {
            throw new IllegalArgumentException("Para agregar stock debe agregar almenos 1 producto");
        } else {
            this.stock += stock;
        }
    }
    
    /**
    * Reduce el stock del producto, siempre que exista suficiente inventario.
    *
    * @param cantidad unidades a restar, debe ser mayor a 0
    * @throws IllegalStateException si cantidad es <= 0
    * @throws IllegalArgumentException si no hay suficiente stock
    */
    public void restarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalStateException("Debe quitar al menos 1 unidad");
        }
        if(stock - cantidad < 0) {
            throw new IllegalArgumentException("No hay suficiente stock para realizar la operación");
        } else {
            this.stock -= cantidad;
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

    /**
    * Establece el código del producto.
    *
    * @param codigo debe ser mayor a 0
    * @throws IllegalArgumentException si el código es inválido
    */
    public void setCodigo(int codigo) {
        if(codigo <= 0) {
            throw new IllegalArgumentException("Código de producto debe ser mayor a 0");
        } else {
            this.codigo = codigo;
        }
    }

    /**
    * Establece el nombre del producto.
    *
    * @param nombreProducto no puede ser nulo ni estar en blanco
    * @throws IllegalArgumentException si el nombre es inválido
    */
    public void setNombreProducto(String nombreProducto) {
        if(nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre del producto no debe estar en blanco");
        } else {
            this.nombreProducto = nombreProducto;
        }
    }

    /**
    * Establece el precio unitario.
    *
    * @param precioUnitario debe ser mayor a 0
    * @throws IllegalArgumentException si el precio es inválido
    */
    public void setPrecioUnitario(double precioUnitario)throws IllegalArgumentException{
        if(precioUnitario <= 0) {
            throw  new IllegalArgumentException("Precio unitario debe ser mayor a 0");
        } else {
            this.precioUnitario = precioUnitario;
        }
    }

    /**
    * Establece el stock inicial.
    *
    * @param stock debe ser mayor a 0
    * @throws IllegalArgumentException si el stock es inválido
    */
    public void setStock(int stock) throws IllegalArgumentException{
        if(stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        } else {
            this.stock = stock;
        }
    }
}
