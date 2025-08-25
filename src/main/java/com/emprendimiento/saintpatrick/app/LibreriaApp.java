package com.emprendimiento.saintpatrick.app;

import com.emprendimiento.saintpatrick.modelo.Libro;
import com.emprendimiento.saintpatrick.usuario.Cliente;

import java.math.BigDecimal;

public class LibreriaApp {
    public static void main(String[] args) {
        Libro libro = new Libro(1, "El Principito", "Clásico",  new BigDecimal("12.99"), 10, "Saint-Exupéry", "Porrua", "nuevo");
        Cliente c = new Cliente(1, "Pato", "pato@mail.com", "1234");
        c.registrarCompra(1001);
        System.out.println(libro);
        System.out.println(c);
    }
}
