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

    public void setOrigen(String origen) {
        if (origen == null || origen.trim().isEmpty()) {
            throw new IllegalArgumentException("El origen no puede estar vacío");
        }
        this.origen = origen.trim();
    }

    public void setTipo(String tipo) {
        if (tipo == null) throw new IllegalArgumentException("El tipo no puede ser nulo");

        String limpio = tipo.trim().toLowerCase();
        if (!limpio.equals("soluble") && !limpio.equals("molido") && !limpio.equals("en grano")) {
            throw new IllegalArgumentException("El tipo debe ser 'soluble', 'molido' o 'en grano'");
        }

        this.tipo = limpio;
    }

    public void setPesoGramos(double pesoGramos) {
        if (pesoGramos <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero");
        }
        this.pesoGramos = pesoGramos;
    }

    @Override
    public String mostrarDetalle() {
        return String.format(java.util.Locale.US,
                "Café: %s [%d]\nOrigen: %s\nTipo: %s\nPeso: %.1f g\nPrecio: $%.2f\nStock: %d unidades",
                getNombre(), getId(), origen, tipo, pesoGramos,
                getPrecio().doubleValue(), getStock()
        );
    }
}