package com.emprendimiento.saintpatrick.fabrica;

import com.emprendimiento.saintpatrick.modelo.*;

import java.util.List;

public class FabricaProducto {

    public static Producto crearCafe(DatosCafe datos) {
        validarTipoCafe(datos.tipo());
        return new Cafe(
                datos.id(), datos.nombre(), datos.descripcion(),
                datos.precio(), datos.stock(),
                datos.origen(), datos.tipo(), datos.pesoGramos()
        );
    }

    private static void validarTipoCafe(String tipo) {
        List<String> permitidos = List.of("molido", "soluble", "en grano");
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de café no puede estar vacío");
        }
        if (!permitidos.contains(tipo.trim().toLowerCase())) {
            throw new IllegalArgumentException("Tipo de café inválido");
        }
    }

    public static Producto crearLibro(DatosLibro datos) {
        validarTipoLibro(datos.estado(), datos.editorial());
        return new Libro(
                datos.id(), datos.nombre(), datos.descripcion(),
                datos.precio(), datos.stock(),
                datos.autor(), datos.editorial(), datos.estado()
        );
    }

    private static void validarTipoLibro(String estado, String editorial) {
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("La editorial no puede estar vacía");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío");
        }
        String limpio = estado.trim().toLowerCase();
        if (!List.of("nuevo", "usado").contains(limpio)) {
            throw new IllegalArgumentException("Estado inválido: debe ser 'nuevo' o 'usado'");
        }
    }

    public static Producto crearSoporte(DatosSoporte datos) {
        validarTipoSoporte(datos.material(), datos.peso());
        return new Soporte(
                datos.id(), datos.nombre(), datos.descripcion(),
                datos.precio(), datos.stock(),
                datos.material(), datos.peso()
        );
    }

    private static void validarTipoSoporte(String material, double peso) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("El material no puede estar vacío");
        }
        String limpio = material.trim().toLowerCase();
        if (!List.of("yeso", "madera", "metal").contains(limpio)) {
            throw new IllegalArgumentException("Material inválido: debe ser 'yeso', 'madera' o 'metal'");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero");
        }
    }

    public static Producto crearSeparador(DatosSeparador datos) {
        validarTipoSeparador(datos.material(), datos.dimensionesCm());
        return new Separador(
                datos.id(), datos.nombre(), datos.descripcion(),
                datos.precio(), datos.stock(),
                datos.material(), datos.dimensionesCm()
        );
    }

    private static void validarTipoSeparador(String material, double dimensionesCm) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("El material no puede estar vacío");
        }
        String limpio = material.trim().toLowerCase();
        if (!List.of("tela", "madera", "metal", "cartón").contains(limpio)) {
            throw new IllegalArgumentException("Material inválido: debe ser 'tela', 'madera', 'metal' o 'cartón'");
        }
        if (dimensionesCm <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben ser mayores a cero");
        }
    }
}
