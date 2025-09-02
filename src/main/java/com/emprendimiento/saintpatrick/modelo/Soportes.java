package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;

public class Soportes extends Producto {
    private String material;        // Ej: "madera", "metal"
    private double peso;  // Peso aproximado en libras

    public Soportes(int id, String nombre, String descripcion, BigDecimal precio, int stock,
                    String material, double peso) {
        super(id, nombre, descripcion, precio, stock);
        this.material = material;
        this.peso = peso;
    }

    public String getMaterial() {
        return material;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String mostrarDetalle() {
        return String.format(
                "Soporte: %s [%d]\nMaterial: %s\nPeso: %.1f lbs.\nPrecio: $%.2f\nStock: %d unidades",
                getNombre(), getId(), material, peso,
                getPrecio().doubleValue(), getStock()
        );
    }
}