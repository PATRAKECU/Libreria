package com.emprendimiento.saintpatrick.modelo;

import java.math.BigDecimal;

public class Cafe extends Producto {
    private String origen;      // Ej: "Colombia", "Brasil"
    private String tipo;  // Ej: "soluble", "pasado"
    private double pesoGramos;  // Peso en gramos

    public Cafe(int id, String nombre, String descripcion, BigDecimal precio, int stock,
                String origen, String tipo, double pesoGramos) {
        super(id, nombre, descripcion, precio, stock);
        this.origen = origen;
        this.tipo = tipo;
        this.pesoGramos = pesoGramos;
    }

    public String getOrigen() {
        return origen;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPesoGramos() {
        return pesoGramos;
    }


    @Override
    public String toString() {
        return String.format(
                "%s\nOrigen: %s\nTipo: %s\nPeso: %.1f g",
                super.toString(), origen, tipo, pesoGramos
        );
    }
}