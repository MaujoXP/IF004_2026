/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un pedido realizado por un cliente sobre un producto.
 * El ID del pedido se asigna automáticamente y aumenta con cada nuevo pedido.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private static int idPedido = 1;
    private int cantidad;
    
    /**
    * Crea un pedido nuevo con un cliente, un producto y una cantidad solicitada.
    * El ID del pedido se asigna automáticamente.
    *
    * @param cliente cliente que realiza el pedido
    * @param producto producto solicitado
    * @param cantidad unidades solicitadas del producto, deben estar disponibles en stock
    * @throws IllegalArgumentException si la cantidad es inválida o supera el stock
    * @throws IllegalStateException si el producto no ha sido asignado
    */
    public Pedido(Cliente cliente, Producto producto, int cantidad) {
        setCliente(cliente);
        setProducto(producto);
        setIdPedido(idPedido++);
        setCantidad(cantidad);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
    * Establece la cantidad solicitada en el pedido.
    * Verifica que sea mayor a 0 y que exista suficiente stock disponible.
    *
    * @param cantidad cantidad de producto solicitada
    * @throws IllegalArgumentException si la cantidad es menor o igual a 0
    * @throws IllegalStateException si no hay un producto asignado aún
    * @throws IllegalArgumentException si la cantidad supera el stock disponible
    */
    public void setCantidad(int cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor a 0");
        }

        if (producto == null) {
            throw new IllegalStateException("Debe asignar un producto antes de definir la cantidad");
        }

        if (producto.getStock() < cantidad) {
            throw new IllegalArgumentException("Cantidad supera el stock disponible");
        }

        this.cantidad = cantidad;
    }
}
