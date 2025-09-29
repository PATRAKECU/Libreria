package com.emprendimiento.saintpatrick.excepciones;

public class ProductoNoEncontrado extends RuntimeException {
    public ProductoNoEncontrado(String message) {
        super(message);
    }
}
