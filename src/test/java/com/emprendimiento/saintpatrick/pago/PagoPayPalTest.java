package com.emprendimiento.saintpatrick.pago;

import com.emprendimiento.saintpatrick.excepciones.PagoFallido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PagoPayPalTest {

    @Test
    void iniciarPago_conMontoValido_deberiaRetornarTrue() {
        PagoPayPal pago = new PagoPayPal();
        assertTrue(pago.iniciarPago(BigDecimal.valueOf(50.0)));
    }

    @Test
    void confirmarPago_sinPagoPrevio_deberiaLanzarExcepcion() {
        PagoPayPal pago = new PagoPayPal();
        assertThrows(PagoFallido.class, pago::confirmarPago);
    }
}