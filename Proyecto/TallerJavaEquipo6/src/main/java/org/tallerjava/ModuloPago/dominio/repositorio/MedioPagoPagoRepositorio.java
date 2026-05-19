package org.tallerjava.ModuloPago.dominio.repositorio;

import org.tallerjava.ModuloPago.dominio.MedioPagoPago;
import java.util.List;

public interface MedioPagoPagoRepositorio {

    void guardar(MedioPagoPago medioPagoPago);

    MedioPagoPago buscarPorIdMedioPago(Long idMedioPago);

    MedioPagoPago buscarPredeterminadoPorCliente(String cedulaCliente);

    List<MedioPagoPago> buscarPorCliente(String cedulaCliente);
}
