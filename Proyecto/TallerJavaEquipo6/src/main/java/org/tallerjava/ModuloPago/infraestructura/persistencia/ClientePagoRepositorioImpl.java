package org.tallerjava.ModuloPago.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.tallerjava.ModuloPago.dominio.ClientePago;
import org.tallerjava.ModuloPago.dominio.repositorio.ClientePagoRepositorio;

@ApplicationScoped
@Transactional
public class ClientePagoRepositorioImpl implements ClientePagoRepositorio {

    @PersistenceContext(unitName = "tallerJavaPU")
    private EntityManager em;

    @Override
    public void guardar(ClientePago clientePago) {
        em.persist(clientePago);
    }

    @Override
    public ClientePago buscarPorCedula(String cedula) {
        return em.find(ClientePago.class, cedula);
    }
}
