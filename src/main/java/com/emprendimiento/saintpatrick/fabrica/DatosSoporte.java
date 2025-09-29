package com.emprendimiento.saintpatrick.fabrica;

import java.math.BigDecimal;

public record DatosSoporte (
    int id,
    String nombre,
    String descripcion,
    BigDecimal precio,
    int stock,
    String material,
    double peso
) {}
