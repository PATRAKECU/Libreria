package com.emprendimiento.saintpatrick.app;

import com.emprendimiento.saintpatrick.excepciones.CarritoVacio;
import com.emprendimiento.saintpatrick.excepciones.UsuarioNoAutenticado;
import com.emprendimiento.saintpatrick.fabrica.*;
import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.notificaciones.*;
import com.emprendimiento.saintpatrick.pago.PagoTarjeta;
import com.emprendimiento.saintpatrick.pago.ProcesoPago;
import com.emprendimiento.saintpatrick.pedidos.GestorPedidos;
import com.emprendimiento.saintpatrick.pedidos.Pedido;
import com.emprendimiento.saintpatrick.usuario.Cliente;

import java.math.BigDecimal;


public class LibreriaApp {
    public static void main(String[] args) {
        // 1. Crear cliente usando fábrica
        DatosUsuario datosCliente = new DatosUsuario("cliente",1, "Patricio", "correo@email.com", "clave123");
        Cliente cliente = (Cliente) FabricaUsuario.crearUsuario(datosCliente);

        // 2. Crear productos usando fábrica
        Producto libro = FabricaProducto.crearLibro(new DatosLibro(
                101, "Clean Code", "Libro técnico", new BigDecimal("39.99"), 5,
                "Robert C. Martin", "Prentice Hall", "nuevo"));

        Producto cafe = FabricaProducto.crearCafe(new DatosCafe(
                102, "Café Premium", "Aromático", new BigDecimal("12.50"), 10,
                "Colombia", "molido", 250));

        Producto soporte = FabricaProducto.crearSoporte(new DatosSoporte(
                103, "Soporte de metal", "Resistente", new BigDecimal("19.99"), 5,
                "metal", 2.5));

        Producto separador = FabricaProducto.crearSeparador(new DatosSeparador(
                104, "Separador de tela", "Decorativo", new BigDecimal("5.99"), 10,
                "tela", 15.0));

        // 3. Agregar productos al carrito
        cliente.getCarrito().agregarProducto(libro);
        cliente.getCarrito().agregarProducto(cafe);
        cliente.getCarrito().agregarProducto(soporte);
        cliente.getCarrito().agregarProducto(separador);

        // 4. Registrar observadores
        GestorEventos eventos = new GestorEventos();
        eventos.registrar(new ActualizadorDashboard());
        eventos.registrar(new NotificadorAdministrador());
        eventos.registrar(new NotificadorEmail());
        eventos.registrar(new NotificadorUI());

        // 5. Confirmar pedido
        GestorPedidos gestor = new GestorPedidos();
        try {
            boolean autenticado = cliente.iniciarSesion("correo@email.com", "clave123");
            if (!autenticado) {
                throw new UsuarioNoAutenticado("Debes iniciar sesión para confirmar tu pedido.");
            }

            Pedido pedido = gestor.confirmarPedido(cliente);
            System.out.println("✅ Pedido confirmado:");
            System.out.println(pedido);

            // 6. Simular pago
            ProcesoPago pago = new PagoTarjeta();
            pago.iniciarPago(pedido.getTotal());
            pago.verificarPago();
            pago.confirmarPago();

            // 7. Emitir evento
            eventos.emitir(Evento.PEDIDO_CONFIRMADO);

        } catch (UsuarioNoAutenticado e) {
            System.out.println("❌ Acceso denegado: " + e.getMessage());
        } catch (CarritoVacio e) {
            System.out.println("🛒 Tu carrito está vacío. ¿Deseas explorar el catálogo?");
        }
    }
}
