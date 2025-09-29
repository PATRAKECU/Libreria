package com.emprendimiento.saintpatrick.excepciones;

public class DatosInvalidos extends RuntimeException {
    public DatosInvalidos(String message) {
        super(message);
    }
}
