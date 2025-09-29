package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;
import java.util.List;

public class Separador extends Producto {
    private String material;    // Ej: "cartón", "plástico"
    private double dimensionesCm;    //Tamaño en cm

    public Separador(int id, String nombre, String descripcion, BigDecimal precio, int stock,
                     String material, double dimensionesCm) {
        super(id, nombre, descripcion, precio, stock);
        this.material = material;
        this.dimensionesCm = dimensionesCm;
    }

    public String getMaterial() {
        return material;
    }

    public double getDimensionesCm() {
        return dimensionesCm;
    }

    public void setMaterial(String material) {
        if (material == null) throw new IllegalArgumentException("El material no puede ser nulo");

        String limpio = material.trim().toLowerCase();
        if (!List.of("tela", "madera", "metal", "cartón").contains(limpio)) {
            throw new IllegalArgumentException("Material inválido: debe ser 'tela', 'madera', 'metal' o 'cartón'");
        }

        this.material = limpio;
    }

    public void setDimensionesCm(double dimensionesCm) {
        if (dimensionesCm <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser mayores a cero");
        }
        this.dimensionesCm = dimensionesCm;
    }

    @Override
    public String mostrarDetalle() {
        return String.format(
                "Separador: %s [%d]\nMaterial: %s\nDimensiones: %.1f cm\nPrecio: $%.2f\nStock: %d unidades",
                getNombre(), getId(), material, dimensionesCm,
                getPrecio().doubleValue(), getStock()
        );
    }
}