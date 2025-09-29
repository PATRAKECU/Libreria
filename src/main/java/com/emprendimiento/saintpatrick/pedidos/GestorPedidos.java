package com.emprendimiento.saintpatrick.pedidos;

import com.emprendimiento.saintpatrick.excepciones.CarritoVacio;
import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.usuario.Cliente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {
    private List<Pedido> pedidos = new ArrayList<>();
    private int contador = 1;

    public Pedido confirmarPedido(Cliente cliente) {
        List<Producto> productos = cliente.getCarrito().getProductos();
        if (productos.isEmpty()) {
            throw new CarritoVacio("No se puede confirmar pedido con carrito vacío.");
        }

        BigDecimal total = cliente.getCarrito().getTotal();
        Pedido pedido = new Pedido(contador++, cliente, productos, total);
        pedidos.add(pedido);

        cliente.registrarCompra(pedido);
        cliente.getCarrito().vaciarCarrito();

        return pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}