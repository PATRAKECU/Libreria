package com.emprendimiento.saintpatrick.inventario;

import com.emprendimiento.saintpatrick.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorInventario {
    private List<Producto> productos;

    public GestorInventario() {
        this.productos = new ArrayList<>();
    }

    public abstract void añadirProducto(Producto p);
    public abstract void eliminarProducto(Producto p);
    public abstract void actualizarStock(Producto p, int cantidad);
}