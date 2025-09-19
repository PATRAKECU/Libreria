package com.emprendimiento.saintpatrick.app;

import com.emprendimiento.saintpatrick.carrito.Carrito;
import com.emprendimiento.saintpatrick.modelo.Cafe;
import com.emprendimiento.saintpatrick.pago.PagoTarjeta;
import com.emprendimiento.saintpatrick.pago.ProcesoPago;

import java.math.BigDecimal;

public class LibreriaApp {
    public static void main(String[] args) {
        // 1. Crear productos
        Cafe cafeColombiano = new Cafe(
                101, "Café Colombiano", "Intenso y aromático",
                new BigDecimal("7.50"), 10,
                "Colombia", "molido", 250.0
        );

        // 2. Crear carrito y agregar producto
        Carrito carrito = new Carrito();
        carrito.agregarProducto(cafeColombiano);

        // 3. Mostrar total
        BigDecimal total = carrito.getTotal();
        System.out.println("Total a pagar: $" + total);

        // 4. Iniciar proceso de pago
        ProcesoPago pago = new PagoTarjeta();
        boolean iniciado = pago.iniciarPago(total);

        if (iniciado && pago.verificarPago()) {
            pago.confirmarPago();
            carrito.vaciarCarrito();
            System.out.println("Pago confirmado. Carrito vaciado.");
        } else {
            System.out.println("Error en el proceso de pago.");
        }
    }
}