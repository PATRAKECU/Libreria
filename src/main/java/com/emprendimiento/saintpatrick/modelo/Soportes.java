package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;
import java.util.List;

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

    public void setMaterial(String material) {
        if (material == null) throw new IllegalArgumentException("El material no puede ser nulo");

        String limpio = material.trim().toLowerCase();
        if (!List.of("yeso", "madera", "metal").contains(limpio)) {
            throw new IllegalArgumentException("Material inválido: debe ser 'yeso', 'madera' o 'metal'");
        }

        this.material = limpio;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero");
        }
        this.peso = peso;
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