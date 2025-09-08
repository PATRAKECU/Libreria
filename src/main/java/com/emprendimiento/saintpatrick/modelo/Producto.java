package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;

abstract public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    //Método constructor con parámetros y atributos
    public Producto(int id, String nombre, String descripcion,
                    BigDecimal precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    //Métodos consultores
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public int getStock() { return stock; }

    //Métodos modificadores
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(BigDecimal precio) {
        if (precio == null || precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        this.precio = precio;
    }
    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    /** Reduce el stock en 1 unidad, lanza IllegalStateException si no hay stock */
    public void disminuirStock() {
        if (stock <= 0) throw new IllegalStateException("Sin stock disponible");
        stock--;
    }

    /** Método sobrecargado que reduce el stock en la cantidad de unidades requerida, lanza IllegalStateException si no hay stock */
    public void disminuirStock(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser positiva");
        if (stock < cantidad) throw new IllegalStateException("No hay suficiente stock disponible");
        stock -= cantidad;
    }

    /** Incrementa el stock en la cantidad requerida */
    public void incrementarStock(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser positiva");
        stock += cantidad;
    }

    abstract public String mostrarDetalle();
}

