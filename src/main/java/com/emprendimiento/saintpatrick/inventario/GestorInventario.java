package com.emprendimiento.saintpatrick.inventario;

import com.emprendimiento.saintpatrick.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorInventario {
    protected List<Producto> inventario;

    public GestorInventario() {
        this.inventario = new ArrayList<>();
    }

    protected List<Producto> getInventario() {
        return inventario;
    }

    public abstract void añadirProducto(Producto p);
    public abstract void eliminarProducto(Producto p);
    public abstract void actualizarStock(Producto p, int cantidad);
}