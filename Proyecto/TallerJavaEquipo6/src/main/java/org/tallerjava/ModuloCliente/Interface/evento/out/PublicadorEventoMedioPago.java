package org.tallerjava.ModuloCliente.Interface.evento.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventoMedioPago {

    @Inject
    Event<MedioPagoAgregadoEvent> evento;

    public void publicar(String cedulaCliente, Long idMedioPago,  String tipoMedioPago, boolean predeterminado) {
                        
        MedioPagoAgregadoEvent e = new MedioPagoAgregadoEvent(
                cedulaCliente, idMedioPago, tipoMedioPago, predeterminado);
        evento.fire(e);
    }
}
