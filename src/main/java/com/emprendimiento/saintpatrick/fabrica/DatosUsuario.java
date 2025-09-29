package com.emprendimiento.saintpatrick.fabrica;

public record DatosUsuario(
        String rol,
        int id,
        String nombre,
        String correo,
        String contraseña
) {}
