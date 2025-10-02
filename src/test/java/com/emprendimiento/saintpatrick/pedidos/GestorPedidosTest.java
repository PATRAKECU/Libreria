package com.emprendimiento.saintpatrick.pedidos;

import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.notificaciones.Evento;
import com.emprendimiento.saintpatrick.notificaciones.GestorEventosTest;
import com.emprendimiento.saintpatrick.usuario.Cliente;
import com.emprendimiento.saintpatrick.excepciones.CarritoVacio;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GestorPedidosTest {

    @Test
    void confirmarPedido_conCarritoVacio_deberiaLanzarExcepcion() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        GestorPedidos gestor = new GestorPedidos();

        assertThrows(CarritoVacio.class, () -> gestor.confirmarPedido(cliente));
    }

    @Test
    void confirmarPedido_conClienteAutenticadoYCarritoValido_deberiaRetornarPedido() {
        // Crear cliente y autenticar
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        cliente.iniciarSesion("correo@email.com", "clave123");

        // Crear producto y agregar al carrito
        Libro libro = new Libro(101, "Clean Code", "Técnico", new BigDecimal("39.99"), 5, "Robert C. Martin", "Prentice Hall", "nuevo");
        cliente.getCarrito().agregarProducto(libro);

        // Crear gestor de pedidos
        GestorPedidos gestor = new GestorPedidos();

        // Confirmar pedido
        Pedido pedido = gestor.confirmarPedido(cliente);

        // Validaciones
        assertNotNull(pedido);
        assertEquals(1, pedido.getProductos().size());
        assertEquals(new BigDecimal("39.99"), pedido.getTotal());
    }

    @Test
    void confirmarPedido_deberiaNotificarObservadores() {
        GestorPedidos gestor = new GestorPedidos();
        GestorEventosTest.ObservadorMock mock = new GestorEventosTest.ObservadorMock();
        gestor.registrarObservador(mock);

        Cliente cliente = clienteConProducto();
        Pedido pedido = gestor.confirmarPedido(cliente);

        assertTrue(mock.recibio(Evento.PEDIDO_CONFIRMADO));
    }

    private Cliente clienteConProducto() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        cliente.iniciarSesion("correo@email.com", "clave123");

        Libro libro = new Libro(101, "Clean Code", "Técnico", new BigDecimal("39.99"), 5,
                "Robert C. Martin", "Prentice Hall", "nuevo");

        cliente.getCarrito().agregarProducto(libro);
        return cliente;
    }
}