package com.emprendimiento.saintpatrick.pago;

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
            throw new IllegalStateException("Pago no aprobado");
        }
    }
}