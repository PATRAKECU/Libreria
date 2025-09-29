package com.emprendimiento.saintpatrick.inventario;

import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.notificaciones.Evento;
import com.emprendimiento.saintpatrick.notificaciones.Observador;
import com.emprendimiento.saintpatrick.notificaciones.Sujeto;

import java.util.ArrayList;
import java.util.List;

public abstract class GestorInventario implements Sujeto {
    protected List<Producto> inventario;
    private List<Observador> observadores = new ArrayList<>();


    public GestorInventario() {
        this.inventario = new ArrayList<>();
    }

    @Override
    public void registrar(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminar(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar(Evento e) {
        for (Observador o : observadores) {
            o.actualizar(e);
        }
    }

    protected List<Producto> getInventario() {
        return inventario;
    }

    public abstract void añadirProducto(Producto p);
    public abstract void eliminarProducto(Producto p);
    public abstract void actualizarStock(Producto p, int cantidad);
}