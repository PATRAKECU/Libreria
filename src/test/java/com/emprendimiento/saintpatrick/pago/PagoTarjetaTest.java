package com.emprendimiento.saintpatrick.pago;

import com.emprendimiento.saintpatrick.excepciones.PagoFallido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PagoTarjetaTest {

    @Test
    void iniciarPago_conMontoValido_deberiaRetornarTrue() {
        PagoTarjeta pago = new PagoTarjeta();
        assertTrue(pago.iniciarPago(BigDecimal.valueOf(100.0)));
    }

    @Test
    void iniciarPago_conMontoCero_deberiaRetornarFalse() {
        PagoTarjeta pago = new PagoTarjeta();
        assertFalse(pago.iniciarPago(BigDecimal.ZERO));
    }

    @Test
    void verificarPago_despuesDePagoValido_deberiaRetornarTrue() {
        PagoTarjeta pago = new PagoTarjeta();
        pago.iniciarPago(BigDecimal.valueOf(50.0));
        assertTrue(pago.verificarPago());
    }

    @Test
    void confirmarPago_sinPagoPrevio_deberiaLanzarPagoFallido() {
        PagoTarjeta pago = new PagoTarjeta();
        assertThrows(PagoFallido.class, pago::confirmarPago);
    }

    @Test
    void reintentarPago_conMontoValido_deberiaRetornarTrue() {
        PagoTarjeta pago = new PagoTarjeta();
        assertTrue(pago.reintentarPago(BigDecimal.valueOf(75.0)));
    }

    @Test
    void reintentarPago_conMontoInvalido_deberiaLanzarExcepcion() {
        PagoTarjeta pago = new PagoTarjeta();
        assertThrows(IllegalArgumentException.class, () -> pago.reintentarPago(BigDecimal.valueOf(-10.0)));
    }
}