package com.emprendimiento.saintpatrick.excepciones;

public class InventarioInsuficiente extends RuntimeException {
    public InventarioInsuficiente(String message) {
        super(message);
    }
}
