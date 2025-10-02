package com.emprendimiento.saintpatrick.fabrica;

import com.emprendimiento.saintpatrick.modelo.Cafe;
import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.modelo.Separador;
import com.emprendimiento.saintpatrick.modelo.Soporte;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FabricaProductoTest {

    @Test
    void crearLibro_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        DatosLibro datos = new DatosLibro(1, "Clean Code", "Libro técnico", new BigDecimal("39.99"), 5, "Robert C. Martin", "Prentice Hall", "nuevo");
        Libro libro = (Libro) FabricaProducto.crearLibro(datos);

        assertEquals("Clean Code", libro.getNombre());
        assertEquals("nuevo", libro.getEstado());
    }

    @Test
    void crearLibro_conEstadoInvalido_deberiaLanzarExcepcion() {
        DatosLibro datos = new DatosLibro(2, "Código Sucio", "Ejemplo", new BigDecimal("29.99"), 3, "Autor", "Editorial", "viejo");

        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearLibro(datos));
    }

    @Test
    void crearCafe_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        DatosCafe datos = new DatosCafe(1, "Café Premium", "Aromático", new BigDecimal("12.50"), 10, "Colombia", "molido", 250);
        Cafe cafe = (Cafe) FabricaProducto.crearCafe(datos);

        assertEquals("molido", cafe.getTipo());
        assertEquals(250, cafe.getPesoGramos());
    }

    @Test
    void crearCafe_conTipoInvalido_deberiaLanzarExcepcion() {
        DatosCafe datos = new DatosCafe(2, "Café Premium", "Aromático", new BigDecimal("12.50"), 10, "Colombia", "pasado", 250);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearCafe(datos));
    }

    @Test
    void crearCafe_conTipoVacio_deberiaLanzarExcepcion() {
        DatosCafe datos = new DatosCafe(3, "Café Premium", "Aromático", new BigDecimal("12.50"), 10, "Colombia", "  ", 250);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearCafe(datos));
    }

    @Test
    void crearSoporte_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        DatosSoporte datos = new DatosSoporte(1, "Soporte de metal", "Resistente", new BigDecimal("19.99"), 5, "metal", 2.5);
        Soporte soporte = (Soporte) FabricaProducto.crearSoporte(datos);

        assertEquals("metal", soporte.getMaterial());
        assertEquals(2.5, soporte.getPeso());
    }

    @Test
    void crearSoporte_conMaterialInvalido_deberiaLanzarExcepcion() {
        DatosSoporte datos = new DatosSoporte(2, "Soporte raro", "Extraño", new BigDecimal("19.99"), 5, "plástico", 2.5);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearSoporte(datos));
    }

    @Test
    void crearSoporte_conPesoInvalido_deberiaLanzarExcepcion() {
        DatosSoporte datos = new DatosSoporte(3, "Soporte liviano", "Frágil", new BigDecimal("19.99"), 5, "madera", 0);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearSoporte(datos));
    }

    @Test
    void crearSeparador_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        DatosSeparador datos = new DatosSeparador(1, "Separador de tela", "Decorativo", new BigDecimal("5.99"), 10, "tela", 15.0);
        Separador separador = (Separador) FabricaProducto.crearSeparador(datos);

        assertEquals("tela", separador.getMaterial());
        assertEquals(15.0, separador.getDimensionesCm());
    }

    @Test
    void crearSeparador_conMaterialInvalido_deberiaLanzarExcepcion() {
        DatosSeparador datos = new DatosSeparador(2, "Separador raro", "Extraño", new BigDecimal("5.99"), 10, "plástico", 15.0);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearSeparador(datos));
    }

    @Test
    void crearSeparador_conDimensionesInvalidas_deberiaLanzarExcepcion() {
        DatosSeparador datos = new DatosSeparador(3, "Separador pequeño", "Mini", new BigDecimal("5.99"), 10, "cartón", 0);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearSeparador(datos));
    }

    @Test
    void crearLibro_conEditorialNula_deberiaLanzarExcepcion() {
        DatosLibro datos = new DatosLibro(4, "Clean Code", "Libro técnico", new BigDecimal("39.99"), 5, "Robert C. Martin", null, "nuevo");
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearLibro(datos));
    }

    @Test
    void crearLibro_conEditorialVacia_deberiaLanzarExcepcion() {
        DatosLibro datos = new DatosLibro(5, "Clean Code", "Libro técnico", new BigDecimal("39.99"), 5, "Robert C. Martin", "  ", "nuevo");
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearLibro(datos));
    }

    @Test
    void crearLibro_conEstadoNulo_deberiaLanzarExcepcion() {
        DatosLibro datos = new DatosLibro(6, "Clean Code", "Libro técnico", new BigDecimal("39.99"), 5, "Robert C. Martin", "Prentice Hall", null);
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearLibro(datos));
    }

    @Test
    void crearLibro_conEstadoVacio_deberiaLanzarExcepcion() {
        DatosLibro datos = new DatosLibro(7, "Clean Code", "Libro técnico", new BigDecimal("39.99"), 5, "Robert C. Martin", "Prentice Hall", "  ");
        assertThrows(IllegalArgumentException.class, () -> FabricaProducto.crearLibro(datos));
    }
}