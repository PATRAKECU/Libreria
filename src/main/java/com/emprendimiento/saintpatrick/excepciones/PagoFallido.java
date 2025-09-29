package com.emprendimiento.saintpatrick.excepciones;

public class PagoFallido extends RuntimeException {
    public PagoFallido(String mensaje) {
        super(mensaje);
    }
}
