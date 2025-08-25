package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.modelo.Producto;

import java.math.BigDecimal;

public class Administrador extends Usuario {
    public Administrador(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
    }

    public void gestionarStock(Producto p, int cantidad) {
        // Lógica para añadir o quitar stock
        if (cantidad > 0) {
            p.incrementarStock(cantidad);
        } else {
            p.disminuirStock(Math.abs(cantidad));
        }
    }

    public void establecerPromocion(Producto p, BigDecimal nuevoPrecio) {
        p.setPrecio(nuevoPrecio);
    }

    @Override
    public String toString() {
        return super.toString() + "\nRol: Administrador";
    }
}