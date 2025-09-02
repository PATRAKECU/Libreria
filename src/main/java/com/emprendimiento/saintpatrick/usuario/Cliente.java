package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.carrito.Carrito;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Integer> historialCompras;   // IDs de pedidos
    private List<String> preferencias;        // Ej: géneros literarios
    private Carrito carrito;

    public Cliente(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
        this.carrito = new Carrito();
        this.historialCompras = new ArrayList<>();
        this.preferencias = new ArrayList<>();
    }

    public List<Integer> getHistorialCompras() {
        return historialCompras;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void agregarPreferencia(String genero) {
        preferencias.add(genero);
    }

    public void registrarCompra(int pedidoId) {
        historialCompras.add(pedidoId);
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