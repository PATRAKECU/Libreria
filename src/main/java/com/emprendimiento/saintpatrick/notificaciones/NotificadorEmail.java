package com.emprendimiento.saintpatrick.notificaciones;

public class NotificadorEmail implements Observador {
    @Override
    public void actualizar(Evento e) {
        if (e == Evento.PEDIDO_CONFIRMADO) {
            System.out.println("Email: Enviando confirmación de pedido al cliente.");
        }
    }
}
