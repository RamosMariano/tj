package org.tallerjava.ModuloPago.dominio.repositorio;

import org.tallerjava.ModuloPago.dominio.ClientePago;

public interface ClientePagoRepositorio {

    void guardar(ClientePago clientePago);

    ClientePago buscarPorCedula(String cedula);
}
