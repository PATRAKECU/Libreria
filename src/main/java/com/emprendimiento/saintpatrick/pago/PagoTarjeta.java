package com.emprendimiento.saintpatrick.pago;

import com.emprendimiento.saintpatrick.excepciones.PagoFallido;

import java.math.BigDecimal;

public class PagoTarjeta implements ProcesoPago {
    private boolean aprobado = false;

    @Override
    public boolean iniciarPago(BigDecimal monto) {
        /** Lógica simulada de validación de tarjeta
         * El monto debe ser mayor a cero para que pueda ser aprobado */
        aprobado = monto.compareTo(BigDecimal.ZERO) > 0;
        return aprobado;
    }

    @Override
    //Permite saber si el pago fue exitoso antes de confirmarlo
    public boolean verificarPago() {
        return aprobado;
    }

    @Override
    public void confirmarPago() {
        if (!aprobado) {
            throw new PagoFallido("No se pudo procesar el pago. Verifica tu método de pago.");
        }
    }

    /**
     * Reintenta el pago con un nuevo monto.
     * @param nuevoMonto Monto a procesar
     * @return true si el pago fue aprobado
     * @throws IllegalArgumentException si el monto es inválido
     */

    public boolean reintentarPago(BigDecimal nuevoMonto) {
        if (nuevoMonto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        return iniciarPago(nuevoMonto);
    }
}