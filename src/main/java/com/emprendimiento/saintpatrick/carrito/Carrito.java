package com.emprendimiento.saintpatrick.carrito;

//Importar las clases necesarias, incluyendo Producto
import com.emprendimiento.saintpatrick.modelo.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private BigDecimal total;

    //Método constructor con parámetros y atributos
    public Carrito() {
        productos = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    //Método analizador para agregar artículos al carrito
    public void agregarProducto(Producto p) {
        productos.add(p);
        calcularTotal();
    }

    //Método analizador para remover artículos del carrito
    public void removerProducto(Producto p) {
        productos.remove(p);
        calcularTotal();
    }

    //Método analizador para vaciar el carrito
    public void vaciarCarrito() {
        productos.clear();
        total = BigDecimal.ZERO;
    }

    //Método analizador para calcular el total del carrito que es llamado en otros métodos
    public void calcularTotal() {
        BigDecimal suma = BigDecimal.ZERO;
        for (Producto p : productos) {
            suma = suma.add(p.getPrecio());
        }
        total = suma;
    }

    //Métodos consultores para obtener atributos específicos
    public BigDecimal getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
