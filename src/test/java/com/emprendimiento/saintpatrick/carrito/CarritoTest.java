package com.emprendimiento.saintpatrick.carrito;

import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.modelo.Producto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarritoTest {

    @Test
    void agregarProducto_deberiaIncrementarCantidad() {
        Carrito carrito = new Carrito();
        Producto libro = new Libro(1, "El Principito", "Literatura", new BigDecimal("12.99"), 10, "Autor", "Editorial", "nuevo");

        carrito.agregarProducto(libro);

        assertEquals(1, carrito.getProductos().size());
        assertEquals(new BigDecimal("12.99"), carrito.getTotal());
    }

    @Test
    void vaciarCarrito_deberiaEliminarTodosLosProductos() {
        Carrito carrito = new Carrito();
        carrito.agregarProducto(new Libro(2, "1984", "Distopía", new BigDecimal("15.99"), 5, "Orwell", "Penguin", "usado"));

        carrito.vaciarCarrito();

        assertTrue(carrito.getProductos().isEmpty());
        assertEquals(BigDecimal.ZERO, carrito.getTotal());
    }

    @Test
    void agregarProductoPorId_conProductoExistente_deberiaAgregarlo() {
        Carrito carrito = new Carrito();
        List<Producto> catalogo = List.of(
                new Libro(10, "Clean Code", "Técnico", new BigDecimal("39.99"), 5, "Martin", "Prentice", "nuevo")
        );

        carrito.agregarProducto(10, catalogo);

        assertEquals(1, carrito.getProductos().size());
        assertEquals(new BigDecimal("39.99"), carrito.getTotal());
    }

    @Test
    void agregarProductoPorId_conProductoInexistente_deberiaLanzarExcepcion() {
        Carrito carrito = new Carrito();
        List<Producto> catalogo = List.of();

        assertThrows(IllegalArgumentException.class, () -> carrito.agregarProducto(99, catalogo));
    }

    @Test
    void agregarProductoPorNombreYPrecio_valido_deberiaAgregarlo() {
        Carrito carrito = new Carrito();
        carrito.agregarProducto("Café Especial", new BigDecimal("8.50"));

        assertEquals(1, carrito.getProductos().size());
        assertEquals(new BigDecimal("8.50"), carrito.getTotal());
    }

    @Test
    void agregarProductoPorNombreYPrecio_invalido_deberiaLanzarExcepcion() {
        Carrito carrito = new Carrito();
        assertThrows(IllegalArgumentException.class, () -> carrito.agregarProducto("Café Especial", BigDecimal.ZERO));
    }

    @Test
    void removerProducto_deberiaEliminarloYActualizarTotal() {
        Carrito carrito = new Carrito();
        Producto libro = new Libro(3, "Refactoring", "Técnico", new BigDecimal("29.99"), 3, "Fowler", "Addison", "nuevo");

        carrito.agregarProducto(libro);
        carrito.removerProducto(libro);

        assertTrue(carrito.getProductos().isEmpty());
        assertEquals(BigDecimal.ZERO, carrito.getTotal());
    }

    @Test
    void esVacio_conCarritoVacio_deberiaRetornarTrue() {
        Carrito carrito = new Carrito();
        assertTrue(carrito.esVacio());
    }

    @Test
    void esVacio_conCarritoConProductos_deberiaRetornarFalse() {
        Carrito carrito = new Carrito();
        carrito.agregarProducto(new Libro(4, "Domain-Driven Design", "Arquitectura", new BigDecimal("49.99"), 2, "Evans", "Addison", "nuevo"));
        assertFalse(carrito.esVacio());
    }

    @Test
    void generarResumen_conCarritoVacio_deberiaRetornarMensaje() {
        Carrito carrito = new Carrito();
        assertEquals("El carrito está vacío.", carrito.generarResumen());
    }

    @Test
    void generarResumen_conProductos_deberiaRetornarResumenCorrecto() {
        Carrito carrito = new Carrito();
        carrito.agregarProducto(new Libro(5, "Patterns of Enterprise", "Arquitectura", new BigDecimal("59.99"), 1, "Fowler", "Addison", "nuevo"));

        String resumen = carrito.generarResumen();
        assertTrue(resumen.contains("Resumen del carrito:"));
        assertTrue(resumen.contains("Patterns of Enterprise"));
        assertTrue(resumen.contains("Total: $59.99"));
    }
}