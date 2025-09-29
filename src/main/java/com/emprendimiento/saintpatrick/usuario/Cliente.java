package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.carrito.Carrito;
import com.emprendimiento.saintpatrick.pedidos.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> historialCompras;   // IDs de pedidos
    private List<String> preferencias;        // Ej: géneros literarios
    private Carrito carrito;

    public Cliente(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
        this.carrito = new Carrito();
        this.historialCompras = new ArrayList<>();
        this.preferencias = new ArrayList<>();
    }

    public List<Pedido> getHistorialCompras() {
        return historialCompras;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void agregarPreferencia(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("La preferencia no puede estar vacía");
        }
        preferencias.add(genero.trim());
    }

    public void registrarCompra(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        historialCompras.add(pedido);
    }

    @Override
    public String mostrarPerfil() {
        return String.format(
                "Cliente: %s [%d]\nCorreo: %s\nPedidos realizados: %d\nProductos en carrito: %d",
                getNombre(), getId(), getCorreo(),
                historialCompras.size(),
                carrito.getProductos().size()
        );
    }
}