package org.tallerjava.ModuloPago.Interface.evento.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.tallerjava.ModuloPago.dominio.ClientePago;
import org.tallerjava.ModuloPago.dominio.repositorio.ClientePagoRepositorio;
import org.tallerjava.ModuloCliente.Interface.evento.out.ClienteRegistradoEvent;

@ApplicationScoped
public class ObserverClienteRegistrado {

    @Inject
    ClientePagoRepositorio clientePagoRepositorio;

    public void onClienteRegistrado(@Observes ClienteRegistradoEvent evento) {
        ClientePago clientePago = new ClientePago(evento.getCedula(),evento.getNombre(),evento.getTipo());
                
        clientePagoRepositorio.guardar(clientePago);
    }
}
