package com.emprendimiento.saintpatrick.notificaciones;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorEventosTest {

    public static class ObservadorMock implements Observador {
        public List<Evento> eventosRecibidos = new ArrayList<>();

        @Override
        public void actualizar(Evento e) {
            eventosRecibidos.add(e);
        }

        public boolean recibio(Evento e) {
            return eventosRecibidos.contains(e);
        }
    }

    @Test
    void registrarObservador_deberiaAgregarloALaLista() {
        GestorEventos gestor = new GestorEventos();
        ObservadorMock mock = new ObservadorMock();

        gestor.registrar(mock);
        gestor.emitir(Evento.PEDIDO_CONFIRMADO);

        assertTrue(mock.recibio(Evento.PEDIDO_CONFIRMADO));
    }

    @Test
    void emitirEvento_deberiaNotificarTodosLosObservadores() {
        GestorEventos gestor = new GestorEventos();
        ObservadorMock mock1 = new ObservadorMock();
        ObservadorMock mock2 = new ObservadorMock();

        gestor.registrar(mock1);
        gestor.registrar(mock2);
        gestor.emitir(Evento.STOCK_ACTUALIZADO);

        assertTrue(mock1.recibio(Evento.STOCK_ACTUALIZADO));
        assertTrue(mock2.recibio(Evento.STOCK_ACTUALIZADO));
    }

    @Test
    void gestorEventos_deberiaNotificarObservadores() {
        GestorEventos gestor = new GestorEventos();
        gestor.registrar(new ActualizadorDashboard());
        gestor.registrar(new NotificadorAdministrador());
        gestor.registrar(new NotificadorEmail());
        gestor.registrar(new NotificadorUI());

        gestor.emitir(Evento.PEDIDO_CONFIRMADO);
        gestor.emitir(Evento.STOCK_ACTUALIZADO);
    }
}