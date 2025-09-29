package com.emprendimiento.saintpatrick.fabrica;

import java.math.BigDecimal;

public record DatosCafe (
    int id,
    String nombre,
    String descripcion,
    BigDecimal precio,
    int stock,
    String origen,
    String tipo,
    double pesoGramos
) {}
