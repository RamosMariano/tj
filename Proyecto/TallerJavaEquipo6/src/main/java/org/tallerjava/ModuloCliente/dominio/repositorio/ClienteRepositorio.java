package org.tallerjava.ModuloCliente.dominio.repositorio;

import org.tallerjava.ModuloCliente.dominio.Cliente;
import java.util.List;


public interface ClienteRepositorio {

    void guardar(Cliente cliente);

    void actualizar(Cliente cliente);

    Cliente buscarPorCedula(String cedula);

    List<Cliente> obtenerTodos();

    void eliminar(String cedula);

    void flush();
}
