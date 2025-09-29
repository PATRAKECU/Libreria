package com.emprendimiento.saintpatrick.excepciones;

public class CarritoVacio extends RuntimeException {
    public CarritoVacio(String message) {
        super(message);
    }
}
