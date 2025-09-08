package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.modelo.Producto;

import java.math.BigDecimal;

public class Administrador extends Usuario {
    public Administrador(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
    }

    public void gestionarStock(Producto p, int cantidad) {
        if (p == null) throw new IllegalArgumentException("Producto no puede ser nulo");
        if (cantidad == 0) throw new IllegalArgumentException("La cantidad no puede ser cero");

        if (cantidad > 0) {
            p.incrementarStock(cantidad);
        } else {
            p.disminuirStock(Math.abs(cantidad));
        }
    }

    public void establecerPromocion(Producto p, BigDecimal nuevoPrecio) {
        if (p == null) throw new IllegalArgumentException("Producto no puede ser nulo");
        if (nuevoPrecio == null || nuevoPrecio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        p.setPrecio(nuevoPrecio);
    }

    @Override
    public String mostrarPerfil() {
        return String.format(
                "Administrador: %s [%d]\nCorreo: %s\nPermisos: Gestión de productos, usuarios y pedidos",
                getNombre(), getId(), getCorreo()
        );
    }
}