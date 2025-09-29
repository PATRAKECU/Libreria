package com.emprendimiento.saintpatrick.usuario;

import com.emprendimiento.saintpatrick.excepciones.CorreoInvalido;
import com.emprendimiento.saintpatrick.excepciones.DatosInvalidos;
import com.emprendimiento.saintpatrick.excepciones.UsuarioNoAutenticado;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;

    //Método constructor con parámetros y atributos
    public Usuario(int id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    //Métodos consultores
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    //Métodos modificadores
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidos("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        if (correo == null || !correo.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            throw new CorreoInvalido("Formato de correo inválido: " + correo);
        }
        this.correo = correo;
    }

    /** Para simplificar, se retorna true si la contraseña y correo coinciden */
    public boolean iniciarSesion(String correo, String contraseña) {
        if (!this.correo.equals(correo) || !this.contraseña.equals(contraseña)) {
            throw new UsuarioNoAutenticado("Credenciales inválidas. Verifica tu correo y contraseña.");
        }
        return true;
    }

    public String mostrarPerfil() {
        return String.format("Usuario: %s [%d]\nCorreo: %s", nombre, id, correo);
    }
}

