package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;

public class Libro extends Producto {
    private String autor;
    private String editorial;
    private String estado;

    public Libro(int id, String nombre, String descripcion, BigDecimal precio, int stock,
                 String autor, String editorial, String estado) {
        super(id, nombre, descripcion, precio, stock);
        this.autor = autor;
        this.editorial = editorial;
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String mostrarDetalle() {
        return String.format(
                "Libro: %s [%d]\nAutor: %s\nEditorial: %s\nEstado: %s\nPrecio: $%.2f\nStock: %d unidades",
                getNombre(), getId(), autor, editorial, estado,
                getPrecio().doubleValue(), getStock()
        );
    }
}