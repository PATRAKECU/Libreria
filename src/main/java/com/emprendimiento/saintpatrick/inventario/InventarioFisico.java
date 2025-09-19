package com.emprendimiento.saintpatrick.inventario;

import com.emprendimiento.saintpatrick.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class InventarioFisico extends GestorInventario {
    private List<Producto> inventario = new ArrayList<>();

    @Override
    public void añadirProducto(Producto p) {
        inventario.add(p);
    }

    @Override
    public void eliminarProducto(Producto p) {
        inventario.remove(p);
    }

    @Override
    public void actualizarStock(Producto p, int cantidad) {
        if (cantidad == 0) {
            throw new IllegalArgumentException("La cantidad no puede ser cero");
        }
        if (!inventario.contains(p)) {
            throw new IllegalStateException("Producto no existe en inventario");
        }
        //Utiliza métodos de Producto
        if (cantidad > 0) {
            p.incrementarStock(cantidad);
        } else {
            p.disminuirStock(Math.abs(cantidad));
        }
    }
}