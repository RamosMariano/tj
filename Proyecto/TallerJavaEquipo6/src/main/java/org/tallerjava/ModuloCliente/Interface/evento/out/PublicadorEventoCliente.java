package org.tallerjava.ModuloCliente.Interface.evento.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoCliente {

    @Inject
    Event<ClienteRegistradoEvent> evento;

    public void publicar(String cedula, String nombre, String tipo) {
        ClienteRegistradoEvent e = new ClienteRegistradoEvent(cedula, nombre, tipo);
        evento.fire(e);
    }
}
