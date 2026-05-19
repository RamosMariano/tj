package org.tallerjava.ModuloCarga.Interface.evento.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.tallerjava.ModuloCarga.dominio.ClienteCarga;
import org.tallerjava.ModuloCarga.dominio.repositorio.ClienteCargaRepositorio;
import org.tallerjava.ModuloCliente.Interface.evento.out.ClienteRegistradoEvent;

@ApplicationScoped
public class ObserverClienteRegistrado {

    @Inject
    ClienteCargaRepositorio clienteCargaRepositorio;

    public void onClienteRegistrado(@Observes ClienteRegistradoEvent evento) {
        ClienteCarga clienteCarga = new ClienteCarga(
                evento.getCedula(),
                evento.getNombre(),
                evento.getTipo()
        );
        clienteCargaRepositorio.guardar(clienteCarga);
    }
}
