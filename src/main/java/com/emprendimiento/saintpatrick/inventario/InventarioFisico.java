package com.emprendimiento.saintpatrick.inventario;

import com.emprendimiento.saintpatrick.excepciones.ProductoNoEncontrado;
import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.notificaciones.Evento;

public class InventarioFisico extends GestorInventario {

    @Override
    public void añadirProducto(Producto p) {
        inventario.add(p);
        notificar(Evento.STOCK_ACTUALIZADO);
    }

    @Override
    public void eliminarProducto(Producto p) {
        inventario.remove(p);
        notificar(Evento.STOCK_ACTUALIZADO);
    }

    @Override
    public void actualizarStock(Producto p, int cantidad) {
        if (cantidad == 0) {
            throw new IllegalArgumentException("La cantidad no puede ser cero");
        }
        if (!inventario.contains(p)) {
            throw new ProductoNoEncontrado("Producto no encontrado en el inventario.");
        }

        //Utiliza métodos de Producto
        if (cantidad > 0) {
            p.incrementarStock(cantidad);
        } else {
            p.disminuirStock(Math.abs(cantidad));
        }
        notificar(Evento.STOCK_ACTUALIZADO);
    }
}