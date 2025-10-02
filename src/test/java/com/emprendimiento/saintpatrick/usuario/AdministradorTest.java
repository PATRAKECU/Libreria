package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.modelo.Libro;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void gestionarStock_conCantidadPositiva_deberiaIncrementarStock() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        Libro libro = libroBase();
        admin.gestionarStock(libro, 5);

        assertEquals(15, libro.getStock());
    }

    @Test
    void gestionarStock_conCantidadNegativa_deberiaDisminuirStock() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        Libro libro = libroBase();
        admin.gestionarStock(libro, -5);

        assertEquals(5, libro.getStock());
    }

    @Test
    void gestionarStock_conProductoNulo_deberiaLanzarExcepcion() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        assertThrows(IllegalArgumentException.class, () -> admin.gestionarStock(null, 5));
    }

    @Test
    void establecerPromocion_conPrecioValido_deberiaActualizarPrecio() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        Libro libro = libroBase();
        admin.establecerPromocion(libro, new BigDecimal("29.99"));

        assertEquals(new BigDecimal("29.99"), libro.getPrecio());
    }

    @Test
    void establecerPromocion_conPrecioInvalido_deberiaLanzarExcepcion() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> admin.establecerPromocion(libro, BigDecimal.ZERO));
    }

    @Test
    void mostrarPerfil_deberiaRetornarFormatoCorrecto() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        String perfil = admin.mostrarPerfil();

        assertTrue(perfil.contains("Administrador: Admin [1]"));
        assertTrue(perfil.contains("Correo: admin@email.com"));
        assertTrue(perfil.contains("Gestión de productos"));
    }

    @Test
    void gestionarStock_conCantidadCero_deberiaLanzarExcepcion() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> admin.gestionarStock(libro, 0));
    }

    @Test
    void establecerPromocion_conProductoNulo_deberiaLanzarExcepcion() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        assertThrows(IllegalArgumentException.class, () -> admin.establecerPromocion(null, new BigDecimal("29.99")));
    }

    @Test
    void establecerPromocion_conPrecioNulo_deberiaLanzarExcepcion() {
        Administrador admin = new Administrador(1, "Admin", "admin@email.com", "clave123");
        Libro libro = libroBase();
        assertThrows(IllegalArgumentException.class, () -> admin.establecerPromocion(libro, null));
    }

    private Libro libroBase() {
        return new Libro(101, "Clean Code", "Técnico", new BigDecimal("39.99"), 10,
                "Robert C. Martin", "Prentice Hall", "nuevo");
    }
}