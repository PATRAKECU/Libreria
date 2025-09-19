package com.emprendimiento.saintpatrick.pago;

import java.math.BigDecimal;

public class PagoPayPal implements ProcesoPago {
    private boolean completado = false;

    @Override
    public boolean iniciarPago(BigDecimal monto) {
        /** Lógica simulada de pasarela PayPal
         * El monto debe ser mayor a cero para que pueda ser aprobado */
        completado = monto.compareTo(BigDecimal.ZERO) > 0;
        return completado;
    }

    @Override
    //Permite saber si el pago fue exitoso antes de confirmarlo
    public boolean verificarPago() {
        return completado;
    }

    @Override
    public void confirmarPago() {
        if (!completado) {
            throw new IllegalStateException("Pago no completado");
        }
        // Lógica para notificar a PayPal
    }
}