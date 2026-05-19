package org.tallerjava.ModuloCarga.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.tallerjava.ModuloCarga.dominio.ClienteCarga;
import org.tallerjava.ModuloCarga.dominio.repositorio.ClienteCargaRepositorio;

@ApplicationScoped
@Transactional
public class ClienteCargaRepositorioImpl implements ClienteCargaRepositorio {

    @PersistenceContext(unitName = "tallerJavaPU")
    private EntityManager em;

    @Override
    public void guardar(ClienteCarga clienteCarga) {
        em.persist(clienteCarga);
    }

    @Override
    public ClienteCarga buscarPorCedula(String cedula) {
        return em.find(ClienteCarga.class, cedula);
    }
}
