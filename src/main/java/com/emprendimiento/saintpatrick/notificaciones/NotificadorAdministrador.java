package com.emprendimiento.saintpatrick.notificaciones;

public class NotificadorAdministrador implements Observador {
    @Override
    public void actualizar(Evento e) {
        if (e == Evento.STOCK_ACTUALIZADO) {
            System.out.println("Admin: Revisar cambios en inventario.");
        }
    }
}
