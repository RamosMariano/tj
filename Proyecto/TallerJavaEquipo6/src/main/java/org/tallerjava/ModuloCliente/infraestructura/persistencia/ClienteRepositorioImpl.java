package org.tallerjava.ModuloCliente.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.tallerjava.ModuloCliente.dominio.Cliente;
import org.tallerjava.ModuloCliente.dominio.repositorio.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClienteRepositorioImpl implements ClienteRepositorio {

    @PersistenceContext(unitName = "tallerJavaPU")
    private EntityManager em;

    @Override
    public void guardar(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        if (em.contains(cliente)) {
            em.flush();
        } else {
            em.merge(cliente);
            em.flush();
        }
    }

    @Override
    public Cliente buscarPorCedula(String cedula) {
        return em.find(Cliente.class, cedula);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
                
    }

    @Override
    public void eliminar(String cedula) {
        Cliente cliente = em.find(Cliente.class, cedula);
        if (cliente == null) {
            throw new IllegalArgumentException("No existe cliente con cédula: " + cedula);
        }
        em.remove(cliente);
    }

    @Override
    public void flush() {
        em.flush();
    }
}
