package com.emprendimiento.saintpatrick.usuario;

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
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }

    /** Para simplificar, se retorna true si la contraseña coincide */
    public boolean autenticar(String pwd) {
        return this.contraseña.equals(pwd);
    }
}

