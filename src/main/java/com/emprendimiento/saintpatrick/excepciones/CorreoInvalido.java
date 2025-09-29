package com.emprendimiento.saintpatrick.excepciones;

public class CorreoInvalido extends RuntimeException {
    public CorreoInvalido(String message) {
        super(message);
    }
}
