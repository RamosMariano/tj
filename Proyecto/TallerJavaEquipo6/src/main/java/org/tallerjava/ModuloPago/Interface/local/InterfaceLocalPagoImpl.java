package org.tallerjava.ModuloPago.Interface.local;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.tallerjava.ModuloPago.aplicacion.ServicioPago;

@ApplicationScoped
public class InterfaceLocalPagoImpl implements InterfaceLocalPago {

    @Inject
    ServicioPago servicioPago;

    @Override
    public boolean pagarCarga(String cedulaCliente, long importeCentavos, long idMedioPago) {
        return servicioPago.pagarCarga(cedulaCliente, importeCentavos, idMedioPago);
    }
}