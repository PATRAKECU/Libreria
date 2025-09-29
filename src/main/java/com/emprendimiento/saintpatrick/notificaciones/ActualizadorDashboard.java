package com.emprendimiento.saintpatrick.notificaciones;

public class ActualizadorDashboard implements Observador {
    @Override
    public void actualizar(Evento e) {
        System.out.println("Dashboard: Refrescando métricas por evento " + e.name());
    }
}
