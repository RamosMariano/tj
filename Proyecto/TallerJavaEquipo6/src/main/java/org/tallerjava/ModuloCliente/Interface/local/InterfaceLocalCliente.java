package org.tallerjava.ModuloCliente.Interface.local;

import org.tallerjava.ModuloCliente.dominio.Cliente;

public interface InterfaceLocalCliente {

    /*
      verifica si un cliente existe por su cedula.
      usado por otros modulos que necesiten saberlo de manera sincrona y sin los eventos.
     */
    boolean existeCliente(String cedula);

    
      //busca un cliente por su cedula y lo devuelve.
    Cliente buscarPorCedula(String cedula);
}
