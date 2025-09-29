package com.emprendimiento.saintpatrick.app;

import com.emprendimiento.saintpatrick.excepciones.CarritoVacio;
import com.emprendimiento.saintpatrick.excepciones.InventarioInsuficiente;
import com.emprendimiento.saintpatrick.excepciones.PagoFallido;
import com.emprendimiento.saintpatrick.excepciones.UsuarioNoAutenticado;
import com.emprendimiento.saintpatrick.fabrica.*;

import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.notificaciones.*;
import com.emprendimiento.saintpatrick.pedidos.GestorPedidos;
import com.emprendimiento.saintpatrick.pedidos.Pedido;
import com.emprendimiento.saintpatrick.usuario.Cliente;

import java.math.BigDecimal;


public class LibreriaApp {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Patricio", "correo@email.com", "clave123");
        GestorPedidos gestor = new GestorPedidos();

        try {
            boolean autenticado = cliente.iniciarSesion("correo@email.com", "clave124");

            if (!autenticado) {
                throw new UsuarioNoAutenticado("Debes iniciar sesión para confirmar tu pedido.");
            }

            Pedido pedido = gestor.confirmarPedido(cliente);
            System.out.println("Pedido confirmado: " + pedido);
        } catch (UsuarioNoAutenticado e) {
            System.out.println("Acceso denegado: " + e.getMessage());
            System.out.println("Redirigiendo al login...");
        } catch (CarritoVacio e) {
            System.out.println("Tu carrito está vacío. ¿Deseas explorar el catálogo?");
        }

    }
}
