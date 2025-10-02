package com.emprendimiento.saintpatrick.inventario;

import com.emprendimiento.saintpatrick.excepciones.InventarioInsuficiente;
import com.emprendimiento.saintpatrick.excepciones.ProductoNoEncontrado;
import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.notificaciones.Evento;
import com.emprendimiento.saintpatrick.notificaciones.GestorEventosTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InventarioFisicoTest {

    @Test
    void añadirProducto_deberiaIncrementarInventario() {
        InventarioFisico inventario = new InventarioFisico();
        Libro libro = libroBase();
        GestorEventosTest.ObservadorMock mock = new GestorEventosTest.ObservadorMock();
        inventario.registrar(mock);

        inventario.añadirProducto(libro);

        assertTrue(inventario.buscarProductoPorId(101).isPresent());
        assertTrue(mock.recibio(Evento.STOCK_ACTUALIZADO));
    }

    @Test
    void buscarProductoPorId_conIdInexistente_deberiaRetornarEmpty() {
        InventarioFisico inventario = new InventarioFisico();
        assertTrue(inventario.buscarProductoPorId(999).isEmpty());
    }

    @Test
    void actualizarStock_conCantidadMayorAlStock_deberiaLanzarInventarioInsuficiente() {
        InventarioFisico inventario = new InventarioFisico();
        Libro libro = libroBase();
        inventario.añadirProducto(libro);

        assertThrows(InventarioInsuficiente.class, () -> inventario.actualizarStock(libro, -20));
    }

    @Test
    void actualizarStock_conProductoNoExistente_deberiaLanzarProductoNoEncontrado() {
        InventarioFisico inventario = new InventarioFisico();
        Libro libro = libroBase();
        assertThrows(ProductoNoEncontrado.class, () -> inventario.actualizarStock(libro, 1));
    }

    @Test
    void eliminarProducto_deberiaNotificarStockActualizado() {
        InventarioFisico inventario = new InventarioFisico();
        GestorEventosTest.ObservadorMock mock = new GestorEventosTest.ObservadorMock();
        inventario.registrar(mock);

        Libro libro = libroBase();
        inventario.añadirProducto(libro);
        mock.eventosRecibidos.clear(); // limpiar notificación previa

        inventario.eliminarProducto(libro);

        assertTrue(mock.recibio(Evento.STOCK_ACTUALIZADO));
    }

    @Test
    void actualizarStock_deberiaNotificarStockActualizado() {
        InventarioFisico inventario = new InventarioFisico();
        GestorEventosTest.ObservadorMock mock = new GestorEventosTest.ObservadorMock();
        inventario.registrar(mock);

        Libro libro = libroBase();
        inventario.añadirProducto(libro);
        mock.eventosRecibidos.clear();

        inventario.actualizarStock(libro, 5);

        assertTrue(mock.recibio(Evento.STOCK_ACTUALIZADO));
    }


    private Libro libroBase() {
        return new Libro(101, "Clean Code", "Técnico", new BigDecimal("39.99"), 10,
                "Robert C. Martin", "Prentice Hall", "nuevo");
    }
}