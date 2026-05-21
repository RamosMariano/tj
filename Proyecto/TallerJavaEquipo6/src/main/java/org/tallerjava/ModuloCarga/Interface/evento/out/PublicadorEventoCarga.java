package org.tallerjava.ModuloCarga.Interface.evento.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PublicadorEventoCarga {

    private static final Logger log = Logger.getLogger(PublicadorEventoCarga.class);

    @Inject
    private Event<EventoCargaFinalizada> eventoCargaFinalizada;

    public void publicarCargaFinalizada(EventoCargaFinalizada evento) {
        log.infof("Publicando EventoCargaFinalizada: idCarga=%d, cliente=%s, importe=%d",
                evento.getIdCarga(), evento.getCedulaCliente(), evento.getImporte());
        eventoCargaFinalizada.fire(evento);
    }
}