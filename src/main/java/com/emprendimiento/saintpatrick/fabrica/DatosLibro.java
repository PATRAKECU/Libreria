package com.emprendimiento.saintpatrick.fabrica;

import java.math.BigDecimal;

public record DatosLibro (
    int id,
    String nombre,
    String descripcion,
    BigDecimal precio,
    int stock,
    String autor,
    String editorial,
    String estado
) {}