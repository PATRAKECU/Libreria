package com.emprendimiento.saintpatrick.modelo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SoporteTest {

    @Test
    void constructor_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        Soporte soporte = new Soporte(3, "Soporte de Madera", "Resistente", new BigDecimal("25.00"), 10,
                "madera", 2.5);

        assertEquals("madera", soporte.getMaterial());
        assertEquals(2.5, soporte.getPeso());
    }

    @Test
    void setMaterial_conValorInvalido_deberiaLanzarExcepcion() {
        Soporte soporte = soporteBase();
        assertThrows(IllegalArgumentException.class, () -> soporte.setMaterial("plástico"));
    }

    @Test
    void setPeso_conValorInvalido_deberiaLanzarExcepcion() {
        Soporte soporte = soporteBase();
        assertThrows(IllegalArgumentException.class, () -> soporte.setPeso(0));
    }

    @Test
    void mostrarDetalle_deberiaRetornarFormatoCorrecto() {
        Soporte soporte = soporteBase();
        String detalle = soporte.mostrarDetalle();

        assertTrue(detalle.startsWith("Soporte: Soporte de Madera [3]"));
        assertTrue(detalle.contains("Material: madera"));
        assertTrue(detalle.contains("Peso: 2.5 lbs."));
    }

    @Test
    void setMaterial_conValorNulo_deberiaLanzarExcepcion() {
        Soporte soporte = soporteBase();
        assertThrows(IllegalArgumentException.class, () -> soporte.setMaterial(null));
    }

    @Test
    void setMaterial_conValorValido_yeso_deberiaActualizarMaterial() {
        Soporte soporte = soporteBase();
        soporte.setMaterial("yeso");
        assertEquals("yeso", soporte.getMaterial());
    }

    @Test
    void setPeso_conValorValido_deberiaActualizarPeso() {
        Soporte soporte = soporteBase();
        soporte.setPeso(3.75);
        assertEquals(3.75, soporte.getPeso());
    }

    private Soporte soporteBase() {
        return new Soporte(3, "Soporte de Madera", "Resistente", new BigDecimal("25.00"), 10,
                "madera", 2.5);
    }
}