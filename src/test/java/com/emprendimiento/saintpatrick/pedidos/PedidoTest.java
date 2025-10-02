package com.emprendimiento.saintpatrick.pedidos;

import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.usuario.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

class PedidoTest {

    @Test
    void constructor_conDatosValidos_deberiaCrearInstanciaCorrecta() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        Producto producto = new Libro(101, "Clean Code", "Técnico", new BigDecimal("39.99"), 5, "Martin", "Prentice", "nuevo");
        Pedido pedido = new Pedido(1, cliente, List.of(producto), new BigDecimal("39.99"));

        assertEquals(1, pedido.getId());
        assertEquals(cliente, pedido.getCliente());
        assertEquals(1, pedido.getProductos().size());
        assertEquals(new BigDecimal("39.99"), pedido.getTotal());
        assertEquals(LocalDate.now(), pedido.getFecha());
    }

    @Test
    void toString_deberiaRetornarFormatoCorrecto() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        Producto producto = new Libro(101, "Clean Code", "Técnico", new BigDecimal("39.99"), 5, "Martin", "Prentice", "nuevo");
        Pedido pedido = new Pedido(1, cliente, List.of(producto), new BigDecimal("39.99"));

        String texto = pedido.toString();
        assertTrue(texto.contains("Pedido #1"));
        assertTrue(texto.contains("Cliente: Patricio"));
        assertTrue(texto.contains("Total: $39.99"));
        assertTrue(texto.contains("Productos: 1"));
    }
}