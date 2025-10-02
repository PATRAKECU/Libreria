package com.emprendimiento.saintpatrick.modelo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CafeTest {

    @Test
    void constructor_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        Cafe cafe = new Cafe(1, "Café Premium", "Aromático", new BigDecimal("12.50"), 20,
                "Colombia", "molido", 250);

        assertEquals("Colombia", cafe.getOrigen());
        assertEquals("molido", cafe.getTipo());
        assertEquals(250, cafe.getPesoGramos());
    }

    @Test
    void setOrigen_conValorInvalido_deberiaLanzarExcepcion() {
        Cafe cafe = cafeBase();
        assertThrows(IllegalArgumentException.class, () -> cafe.setOrigen("  "));
    }

    @Test
    void setTipo_conValorInvalido_deberiaLanzarExcepcion() {
        Cafe cafe = cafeBase();
        assertThrows(IllegalArgumentException.class, () -> cafe.setTipo("pasado"));
    }

    @Test
    void setPesoGramos_conValorInvalido_deberiaLanzarExcepcion() {
        Cafe cafe = cafeBase();
        assertThrows(IllegalArgumentException.class, () -> cafe.setPesoGramos(0));
    }

    @Test
    void mostrarDetalle_deberiaRetornarFormatoCorrecto() {
        Cafe cafe = cafeBase();
        String detalle = cafe.mostrarDetalle();

        assertTrue(detalle.startsWith("Café: Café Premium [1]"));
        assertTrue(detalle.contains("Origen: Colombia"));
        assertTrue(detalle.contains("Tipo: molido"));
        assertTrue(detalle.contains("Peso: 250.0 g"));
    }

    @Test
    void setOrigen_conValorNulo_deberiaLanzarExcepcion() {
        Cafe cafe = cafeBase();
        assertThrows(IllegalArgumentException.class, () -> cafe.setOrigen(null));
    }

    @Test
    void setTipo_conValorNulo_deberiaLanzarExcepcion() {
        Cafe cafe = cafeBase();
        assertThrows(IllegalArgumentException.class, () -> cafe.setTipo(null));
    }

    @Test
    void setTipo_conValorValido_soluble_deberiaActualizarTipo() {
        Cafe cafe = cafeBase();
        cafe.setTipo("soluble");
        assertEquals("soluble", cafe.getTipo());
    }

    @Test
    void setTipo_conValorValido_enGrano_deberiaActualizarTipo() {
        Cafe cafe = cafeBase();
        cafe.setTipo("en grano");
        assertEquals("en grano", cafe.getTipo());
    }

    @Test
    void setPesoGramos_conValorValido_deberiaActualizarPeso() {
        Cafe cafe = cafeBase();
        cafe.setPesoGramos(500);
        assertEquals(500, cafe.getPesoGramos());
    }

    @Test
    void setTipo_conValorValido_molido_deberiaActualizarTipo() {
        Cafe cafe = cafeBase();
        cafe.setTipo("molido");
        assertEquals("molido", cafe.getTipo());
    }

    private Cafe cafeBase() {
        return new Cafe(1, "Café Premium", "Aromático", new BigDecimal("12.50"), 20,
                "Colombia", "molido", 250);
    }
}