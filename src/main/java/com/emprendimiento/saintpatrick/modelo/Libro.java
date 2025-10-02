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

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        this.autor = autor.trim();
    }

    public void setEditorial(String editorial) {
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("La editorial no puede estar vacía");
        }
        this.editorial = editorial.trim();
    }

    public void setEstado(String estado) {
        if (estado == null) throw new IllegalArgumentException("El estado no puede ser nulo");

        String limpio = estado.trim().toLowerCase();
        if (!limpio.equals("nuevo") && !limpio.equals("usado")) {
            throw new IllegalArgumentException("El estado debe ser 'nuevo' o 'usado'");
        }

        this.estado = limpio;
    }

    @Override
    public String mostrarDetalle() {
        return String.format(java.util.Locale.US,
                "Libro: %s [%d]\nAutor: %s\nEditorial: %s\nEstado: %s\nPrecio: $%.2f\nStock: %d unidades",
                getNombre(), getId(), autor, editorial, estado,
                getPrecio().doubleValue(), getStock()
        );
    }
}