package com.emprendimiento.saintpatrick.notificaciones;

import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    private List<Observador> observadores = new ArrayList<>();

    public void registrar(Observador o) {
        observadores.add(o);
    }

    public void emitir(Evento e) {
        for (Observador o : observadores) {
            o.actualizar(e);
        }
    }

}
