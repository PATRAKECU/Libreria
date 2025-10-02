package com.emprendimiento.saintpatrick.fabrica;

import com.emprendimiento.saintpatrick.usuario.Usuario;
import com.emprendimiento.saintpatrick.usuario.Cliente;
import com.emprendimiento.saintpatrick.usuario.Administrador;
import com.emprendimiento.saintpatrick.excepciones.CorreoInvalido;
import com.emprendimiento.saintpatrick.excepciones.DatosInvalidos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaUsuarioTest {

    @Test
    void crearUsuario_conRolCliente_deberiaRetornarInstanciaCliente() {
        DatosUsuario datos = new DatosUsuario("cliente",1, "Patricio", "correo@email.com", "clave123");
        Usuario usuario = FabricaUsuario.crearUsuario(datos);

        assertTrue(usuario instanceof Cliente);
        assertEquals("Patricio", usuario.getNombre());
    }

    @Test
    void crearUsuario_conRolAdministrador_deberiaRetornarInstanciaAdministrador() {
        DatosUsuario datos = new DatosUsuario("administrador", 2, "Admin", "admin@email.com", "admin123");
        Usuario usuario = FabricaUsuario.crearUsuario(datos);

        assertTrue(usuario instanceof Administrador);
        assertEquals("Admin", usuario.getNombre());
    }

    @Test
    void crearUsuario_conRolDesconocido_deberiaLanzarExcepcion() {
        DatosUsuario datos = new DatosUsuario("invitado",3, "Desconocido", "x@email.com", "clave123");

        assertThrows(IllegalArgumentException.class, () -> FabricaUsuario.crearUsuario(datos));
    }

    @Test
    void crearUsuario_conCorreoInvalido_deberiaLanzarCorreoInvalido() {
        DatosUsuario datos = new DatosUsuario("cliente",4, "Patricio", "correo-invalido", "clave123");

        assertThrows(CorreoInvalido.class, () -> FabricaUsuario.crearUsuario(datos));
    }

    @Test
    void crearUsuario_conNombreVacio_deberiaLanzarDatosInvalidos() {
        DatosUsuario datos = new DatosUsuario("cliente",5, "   ", "correo@email.com", "clave123");

        assertThrows(DatosInvalidos.class, () -> FabricaUsuario.crearUsuario(datos));
    }

    @Test
    void crearUsuario_conContraseñaCorta_deberiaLanzarIllegalArgumentException() {
        DatosUsuario datos = new DatosUsuario("cliente",6, "Patricio", "correo@email.com", "123");

        assertThrows(IllegalArgumentException.class, () -> FabricaUsuario.crearUsuario(datos));
    }
}