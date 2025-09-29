package com.emprendimiento.saintpatrick.excepciones;

public class UsuarioNoAutenticado extends RuntimeException {
    public UsuarioNoAutenticado(String message) {
        super(message);
    }
}
