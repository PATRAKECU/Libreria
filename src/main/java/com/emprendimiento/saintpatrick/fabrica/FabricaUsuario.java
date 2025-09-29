package com.emprendimiento.saintpatrick.fabrica;

import com.emprendimiento.saintpatrick.excepciones.CorreoInvalido;
import com.emprendimiento.saintpatrick.excepciones.DatosInvalidos;
import com.emprendimiento.saintpatrick.usuario.Administrador;
import com.emprendimiento.saintpatrick.usuario.Cliente;
import com.emprendimiento.saintpatrick.usuario.Usuario;

public class FabricaUsuario {

    public static Usuario crearUsuario(DatosUsuario datos) {
        validarDatos(datos);

        return switch (datos.rol().trim().toLowerCase()) {
            case "cliente" -> new Cliente(datos.id(), datos.nombre(), datos.correo(), datos.contraseña());
            case "administrador" -> new Administrador(datos.id(), datos.nombre(), datos.correo(), datos.contraseña());
            default -> throw new IllegalArgumentException("Rol de usuario desconocido: " + datos.rol());
        };
    }

    private static void validarDatos(DatosUsuario datos) {
        if (datos.nombre() == null || datos.nombre().trim().isEmpty()) {
            throw new DatosInvalidos("El nombre no puede estar vacío");

        }
        if (datos.correo() == null || !datos.correo().matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            throw new CorreoInvalido("Formato de correo inválido: " + datos.correo());
        }
        if (datos.contraseña() == null || datos.contraseña().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }
    }
}

