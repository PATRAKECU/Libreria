package com.emprendimiento.saintpatrick.notificaciones;

public class NotificadorUI implements Observador {
    @Override
    public void actualizar(Evento e) {
        switch (e) {
            case PEDIDO_CONFIRMADO:
                System.out.println("UI: Pedido confirmado, actualizar vista.");
                break;
            case STOCK_ACTUALIZADO:
                System.out.println("UI: Stock cambió, refrescar listado.");
                break;
        }
    }
}
