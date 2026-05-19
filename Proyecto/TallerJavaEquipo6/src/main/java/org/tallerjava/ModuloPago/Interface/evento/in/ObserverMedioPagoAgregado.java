package org.tallerjava.ModuloPago.Interface.evento.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.tallerjava.ModuloPago.dominio.MedioPagoPago;
import org.tallerjava.ModuloPago.dominio.repositorio.MedioPagoPagoRepositorio;
import org.tallerjava.ModuloCliente.Interface.evento.out.MedioPagoAgregadoEvent;

@ApplicationScoped
public class ObserverMedioPagoAgregado {

    @Inject
    MedioPagoPagoRepositorio medioPagoPagoRepositorio;

    public void onMedioPagoAgregado(@Observes MedioPagoAgregadoEvent evento) {
        MedioPagoPago medioPagoPago = new MedioPagoPago(
                evento.getCedulaCliente(),
                evento.getIdMedioPago(),
                evento.getTipoMedioPago(),
                evento.isPredeterminado()
        );
        medioPagoPagoRepositorio.guardar(medioPagoPago);
    }
}
