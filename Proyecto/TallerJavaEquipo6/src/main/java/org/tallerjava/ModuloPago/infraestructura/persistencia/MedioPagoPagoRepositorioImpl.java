package org.tallerjava.ModuloPago.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.tallerjava.ModuloPago.dominio.MedioPagoPago;
import org.tallerjava.ModuloPago.dominio.repositorio.MedioPagoPagoRepositorio;

import java.util.List;

@ApplicationScoped
@Transactional
public class MedioPagoPagoRepositorioImpl implements MedioPagoPagoRepositorio {

    @PersistenceContext(unitName = "tallerJavaPU")
    private EntityManager em;


    @Override
    public void guardar(MedioPagoPago medioPagoPago) {
        em.persist(medioPagoPago);
    }

    @Override
    public MedioPagoPago buscarPorIdMedioPago(Long idMedioPago) {

        return em.find(MedioPagoPago.class, idMedioPago);
    }

    @Override
    public MedioPagoPago buscarPredeterminadoPorCliente(String cedulaCliente) {
        List<MedioPagoPago> resultados = em.createQuery(
                "SELECT m FROM MedioPagoPago m WHERE m.cedulaCliente = :cedula " +
                "AND m.predeterminado = true",
                MedioPagoPago.class)
                .setParameter("cedula", cedulaCliente)
                .getResultList();

        if (resultados.isEmpty()) {
            return null;
        }
        return resultados.get(0);
    }

    @Override
    public List<MedioPagoPago> buscarPorCliente(String cedulaCliente) {
        return em.createQuery(
                "SELECT m FROM MedioPagoPago m WHERE m.cedulaCliente = :cedula",
                MedioPagoPago.class)
                .setParameter("cedula", cedulaCliente)
                .getResultList();
    }
}
