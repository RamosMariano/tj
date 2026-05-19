package org.tallerjava.ModuloCarga.dominio.repositorio;

import org.tallerjava.ModuloCarga.dominio.ClienteCarga;

public interface ClienteCargaRepositorio {

    void guardar(ClienteCarga clienteCarga);

    ClienteCarga buscarPorCedula(String cedula);
}
