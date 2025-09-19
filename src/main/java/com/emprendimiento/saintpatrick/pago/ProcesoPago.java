package com.emprendimiento.saintpatrick.pago;

import java.math.BigDecimal;

public interface ProcesoPago {
    boolean iniciarPago(BigDecimal monto);
    boolean verificarPago();
    void confirmarPago();
}