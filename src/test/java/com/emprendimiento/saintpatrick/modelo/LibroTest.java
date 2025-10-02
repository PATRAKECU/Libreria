package com.emprendimiento.saintpatrick.modelo;

import com.emprendimiento.saintpatrick.excepciones.InventarioInsuficiente;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void constructor_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        Libro libro = new Libro(1, "Clean Code", "Técnico", new BigDecimal("39.99"), 10,
                "Robert C. Martin", "Prentice Hall", "nuevo");

        assertEquals("Clean Code", libro.getNombre());
        assertEquals("Robert C. Martin", libro.getAutor());
        assertEquals("Prentice Hall", libro.getEditorial());
        assertEquals("nuevo", libro.getEstado());
        assertEquals(10, libro.getStock());
    }

    @Test
    void setAutor_conValorValido_deberiaActualizarAutor() {
        Libro libro = libroBase();
        libro.setAutor("Martin Fowler");

        assertEquals("Martin Fowler", libro.getAutor());
    }

    @Test
    void setAutor_conValorInvalido_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setAutor("  "));
    }

    @Test
    void setEditorial_conValorValido_deberiaActualizarEditorial() {
        Libro libro = libroBase();
        libro.setEditorial("O'Reilly");

        assertEquals("O'Reilly", libro.getEditorial());
    }

    @Test
    void setEditorial_conValorInvalido_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setEditorial(null));
    }

    @Test
    void setEstado_conValorValidoNuevo_deberiaActualizarEstado() {
        Libro libro = libroBase();
        libro.setEstado("Nuevo");

        assertEquals("nuevo", libro.getEstado());
    }

    @Test
    void setEstado_conValorValidoUsado_deberiaActualizarEstado() {
        Libro libro = libroBase();
        libro.setEstado("Usado");

        assertEquals("usado", libro.getEstado());
    }

    @Test
    void setEstado_conValorInvalido_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setEstado("reparado"));
    }

    @Test
    void mostrarDetalle_deberiaRetornarFormatoCorrecto() {
        Libro libro = new Libro(1, "Clean Code", "Técnico", new BigDecimal("39.99"), 10,
                "Robert C. Martin", "Prentice Hall", "nuevo");

        String detalle = libro.mostrarDetalle();

        assertTrue(detalle.startsWith("Libro: Clean Code [1]"));
        assertTrue(detalle.contains("Autor: Robert C. Martin"));
        assertTrue(detalle.contains("Editorial: Prentice Hall"));
        assertTrue(detalle.contains("Estado: nuevo"));
        assertTrue(detalle.contains("Precio: $39.99"));
        assertTrue(detalle.contains("Stock: 10 unidades"));
    }

    @Test
    void setAutor_conValorNulo_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setAutor(null));
    }

    @Test
    void setEditorial_conValorVacio_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setEditorial("  "));
    }

    @Test
    void setEstado_conValorNulo_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setEstado(null));
    }

    @Test
    void setPrecio_conValorInvalido_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setPrecio(BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () -> libro.setPrecio(null));
    }

    @Test
    void setStock_conValorNegativo_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.setStock(-1));
    }

    @Test
    void disminuirStock_sinStock_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        libro.setStock(0);
        assertThrows(IllegalStateException.class, libro::disminuirStock);
    }

    @Test
    void disminuirStock_conCantidadInvalida_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.disminuirStock(0));
        assertThrows(IllegalArgumentException.class, () -> libro.disminuirStock(-3));
    }

    @Test
    void disminuirStock_conCantidadMayorAlStock_deberiaLanzarInventarioInsuficiente() {
        Libro libro = libroBase();
        assertThrows(InventarioInsuficiente.class, () -> libro.disminuirStock(100));
    }

    @Test
    void incrementarStock_conCantidadInvalida_deberiaLanzarExcepcion() {
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> libro.incrementarStock(0));
    }

    // Método auxiliar para instancias base
    private Libro libroBase() {
        return new Libro(1, "Clean Code", "Técnico", new BigDecimal("39.99"), 10,
                "Robert C. Martin", "Prentice Hall", "nuevo");
    }

}