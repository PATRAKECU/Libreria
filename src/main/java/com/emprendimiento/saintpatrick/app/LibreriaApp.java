package com.emprendimiento.saintpatrick.app;

import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.usuario.Cliente;
import java.math.BigDecimal;

public class LibreriaApp {

    public static void main(String[] args) {
        // Crear producto
        Producto libro = new Libro(1, "El Principito", "Clásico", new BigDecimal("12.99"), 10,
                "Saint-Exupéry", "Porrua", "nuevo");

        // Crear cliente
        Cliente cliente = new Cliente(101, "Patricio", "pato@mail.com", "1234");

        // Agregar producto al carrito
        cliente.getCarrito().agregarProducto(libro);

        // Registrar una compra simulada
        cliente.registrarCompra(1001); // ID ficticio de pedido

        // Mostrar perfil del cliente
        System.out.println(cliente.mostrarPerfil());
    }
}