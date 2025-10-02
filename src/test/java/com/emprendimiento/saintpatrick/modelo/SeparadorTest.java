package com.emprendimiento.saintpatrick.modelo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SeparadorTest {

    @Test
    void constructor_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        Separador sep = new Separador(2, "Separador Floral", "Decorativo", new BigDecimal("3.99"), 50,
                "cartón", 15);

        assertEquals("cartón", sep.getMaterial());
        assertEquals(15, sep.getDimensionesCm());
    }

    @Test
    void setMaterial_conValorInvalido_deberiaLanzarExcepcion() {
        Separador sep = separadorBase();
        assertThrows(IllegalArgumentException.class, () -> sep.setMaterial("plástico"));
    }

    @Test
    void setDimensionesCm_conValorInvalido_deberiaLanzarExcepcion() {
        Separador sep = separadorBase();
        assertThrows(IllegalArgumentException.class, () -> sep.setDimensionesCm(0));
    }

    @Test
    void mostrarDetalle_deberiaRetornarFormatoCorrecto() {
        Separador sep = separadorBase();
        String detalle = sep.mostrarDetalle();

        assertTrue(detalle.startsWith("Separador: Separador Floral [2]"));
        assertTrue(detalle.contains("Material: cartón"));
        assertTrue(detalle.contains("Dimensiones: 15.0 cm"));
    }

    @Test
    void setMaterial_conValorNulo_deberiaLanzarExcepcion() {
        Separador sep = separadorBase();
        assertThrows(IllegalArgumentException.class, () -> sep.setMaterial(null));
    }

    @Test
    void setMaterial_conValorValido_tela_deberiaActualizarMaterial() {
        Separador sep = separadorBase();
        sep.setMaterial("tela");
        assertEquals("tela", sep.getMaterial());
    }

    @Test
    void setDimensionesCm_conValorValido_deberiaActualizarDimensiones() {
        Separador sep = separadorBase();
        sep.setDimensionesCm(20.5);
        assertEquals(20.5, sep.getDimensionesCm());
    }

    private Separador separadorBase() {
        return new Separador(2, "Separador Floral", "Decorativo", new BigDecimal("3.99"), 50,
                "cartón", 15);
    }
}