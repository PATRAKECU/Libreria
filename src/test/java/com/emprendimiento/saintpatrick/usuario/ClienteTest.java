package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.excepciones.CorreoInvalido;
import com.emprendimiento.saintpatrick.excepciones.DatosInvalidos;
import com.emprendimiento.saintpatrick.excepciones.UsuarioNoAutenticado;
import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.pedidos.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void iniciarSesion_conCredencialesValidas_deberiaAutenticar() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertTrue(cliente.iniciarSesion("correo@email.com", "clave123"));
    }

    @Test
    void iniciarSesion_conCredencialesInvalidas_deberiaLanzarExcepcion() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertThrows(UsuarioNoAutenticado.class, () -> cliente.iniciarSesion("otro@email.com", "clave123"));
    }

    @Test
    void setCorreo_conFormatoInvalido_deberiaLanzarExcepcion() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");

        assertThrows(CorreoInvalido.class, () -> cliente.setCorreo("correo-invalido"));
    }

    @Test
    void setCorreo_conFormatoValido_deberiaActualizarCorreo() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");

        cliente.setCorreo("nuevo@email.com");

        assertEquals("nuevo@email.com", cliente.getCorreo());
    }

    @Test
    void agregarPreferencia_conGeneroValido_deberiaAgregarlo() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        cliente.agregarPreferencia("Fantasía");

        assertEquals(1, cliente.getPreferencias().size());
        assertEquals("Fantasía", cliente.getPreferencias().get(0));
    }

    @Test
    void agregarPreferencia_conGeneroVacio_deberiaLanzarExcepcion() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertThrows(IllegalArgumentException.class, () -> cliente.agregarPreferencia("  "));
    }

    @Test
    void registrarCompra_conPedidoValido_deberiaAgregarAlHistorial() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        Pedido pedido = new Pedido(1, cliente, List.of(), BigDecimal.ZERO);

        cliente.registrarCompra(pedido);

        assertEquals(1, cliente.getHistorialCompras().size());
        assertEquals(pedido, cliente.getHistorialCompras().get(0));
    }

    @Test
    void registrarCompra_conPedidoNulo_deberiaLanzarExcepcion() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertThrows(IllegalArgumentException.class, () -> cliente.registrarCompra(null));
    }

    @Test
    void mostrarPerfil_deberiaRetornarResumenCorrecto() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        cliente.agregarPreferencia("Técnico");
        cliente.getCarrito().agregarProducto(new Libro(1, "Clean Code", "Técnico", new BigDecimal("39.99"), 5, "Martin", "Prentice", "nuevo"));
        cliente.registrarCompra(new Pedido(1, cliente, List.of(), BigDecimal.ZERO));

        String perfil = cliente.mostrarPerfil();

        assertTrue(perfil.contains("Cliente: Patricio [1]"));
        assertTrue(perfil.contains("Correo: correo@email.com"));
        assertTrue(perfil.contains("Pedidos realizados: 1"));
        assertTrue(perfil.contains("Productos en carrito: 1"));
    }

    @Test
    void getCarrito_deberiaRetornarInstanciaNoNula() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertNotNull(cliente.getCarrito());
    }

    @Test
    void getHistorialCompras_deberiaRetornarListaVaciaInicialmente() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertTrue(cliente.getHistorialCompras().isEmpty());
    }

    @Test
    void getPreferencias_deberiaRetornarListaVaciaInicialmente() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertTrue(cliente.getPreferencias().isEmpty());
    }

    @Test
    void setNombre_conValorValido_deberiaActualizarNombre() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        cliente.setNombre("Patricio Actualizado");
        assertEquals("Patricio Actualizado", cliente.getNombre());
    }

    @Test
    void setNombre_conValorInvalido_deberiaLanzarExcepcion() {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        assertThrows(DatosInvalidos.class, () -> cliente.setNombre("  "));
    }
}