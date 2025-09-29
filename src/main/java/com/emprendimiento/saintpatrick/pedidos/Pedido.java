package com.emprendimiento.saintpatrick.pedidos;

import com.emprendimiento.saintpatrick.modelo.Producto;
import com.emprendimiento.saintpatrick.usuario.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private BigDecimal total;
    private LocalDate fecha;

    public Pedido(int id, Cliente cliente, List<Producto> productos, BigDecimal total) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
        this.fecha = LocalDate.now();
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return productos; }
    public BigDecimal getTotal() { return total; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return String.format("Pedido #%d\nCliente: %s\nTotal: $%.2f\nFecha: %s\nProductos: %d",
                id, cliente.getNombre(), total, fecha, productos.size());
    }

}