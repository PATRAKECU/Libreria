package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;

public class Separadores extends Producto {
    private String material;    // Ej: "cartón", "plástico"
    private double dimensionesCm;    //Tamaño en cm

    public Separadores(int id, String nombre, String descripcion, BigDecimal precio, int stock,
                       String material, double dimensionesCm) {
        super(id, nombre, descripcion, precio, stock);
        this.material = material;
        this.dimensionesCm = dimensionesCm;
    }

    public String getMaterial() {
        return material;
    }

    public String getDimensionesCm() {
        return dimensionesCm;
    }

    @Override
    public String toString() {
        return String.format(
                "%s\nMaterial: %s\nDimensiones: %s",
                super.toString(), material, dimensionesCm
        );
    }
}