package com.emprendimiento.saintpatrick.carrito;

import com.emprendimiento.saintpatrick.modelo.Producto;
import java.math.BigDecimal;
import java.util.List;

public interface GestorCarrito {

    void agregarProducto(Producto p);
    void agregarProducto(int id, List<Producto> catalogo);
    void agregarProducto(String nombre, BigDecimal precio);

    void removerProducto(Producto p);
    void vaciarCarrito();

    void calcularTotal();

    BigDecimal getTotal();
    List<Producto> getProductos();
}