package com.emprendimiento.saintpatrick.carrito;

//Importar las clases necesarias, incluyendo Producto
import com.emprendimiento.saintpatrick.modelo.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Ahora Carrito implementa su interfaz de gestión
public class Carrito implements GestorCarrito {
    private List<Producto> productos;
    private BigDecimal total;

    //Método constructor con atributos
    public Carrito() {
        productos = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    //Método analizador para agregar artículos al carrito
    @Override
    public void agregarProducto(Producto p) {
        productos.add(p);
        calcularTotal();

    }

    /** Sobrecarga: agrega por ID (busca en catálogo simulado) */
    @Override
    public void agregarProducto(int id, List<Producto> catalogo) {
        for (Producto p : catalogo) {
            if (p.getId() == id) {
                agregarProducto(p);
                return;
            }
        }
        throw new IllegalArgumentException("Producto con id " + id + " no encontrado");
    }


    /** Sobrecarga: crea y agrega un producto genérico por nombre y precio */
    @Override
    public void agregarProducto(String nombre, BigDecimal precio) {
        if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        Producto temporal = new Producto(0, nombre, "", precio, 1) {
            @Override
            public String mostrarDetalle() {
                return String.format("%s – $%.2f", nombre, precio.doubleValue());
            }
        };
        agregarProducto(temporal);
    }


    //Método analizador para remover artículos del carrito
    @Override
    public void removerProducto(Producto p) {
        productos.remove(p);
        calcularTotal();
    }

    //Método analizador para vaciar el carrito
    @Override
    public void vaciarCarrito() {
        productos.clear();
        total = BigDecimal.ZERO;
    }

    //Método analizador para calcular el total del carrito que es llamado en otros métodos
    @Override
    public void calcularTotal() {
        BigDecimal suma = BigDecimal.ZERO;
        for (Producto p : productos) {
            suma = suma.add(p.getPrecio());
        }
        total = suma;
    }

    //Métodos consultores para obtener atributos específicos
    @Override
    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
