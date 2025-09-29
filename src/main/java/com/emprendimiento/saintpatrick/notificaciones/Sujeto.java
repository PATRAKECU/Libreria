package com.emprendimiento.saintpatrick.notificaciones;

public interface Sujeto {
    void registrar(Observador o);
    void eliminar(Observador o);
    void notificar(Evento e);
}
