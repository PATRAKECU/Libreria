package com.emprendimiento.saintpatrick.usuario;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Integer> historialCompras;   // IDs de pedidos
    private List<String> preferencias;        // Ej: géneros literarios

    public Cliente(int id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
        this.historialCompras = new ArrayList<>();
        this.preferencias = new ArrayList<>();
    }

    public List<Integer> getHistorialCompras() {
        return historialCompras;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }

    public void agregarPreferencia(String genero) {
        preferencias.add(genero);
    }

    public void registrarCompra(int pedidoId) {
        historialCompras.add(pedidoId);
    }

    @Override
    public String toString() {
        return String.format(
                "%s\nCompras realizadas: %d\nPreferencias: %s",
                super.toString(),
                historialCompras.size(),
                preferencias.isEmpty() ? "Ninguna" : String.join(", ", preferencias)
        );
    }
}