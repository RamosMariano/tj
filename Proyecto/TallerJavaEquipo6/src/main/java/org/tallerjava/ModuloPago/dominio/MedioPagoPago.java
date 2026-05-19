package org.tallerjava.ModuloPago.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "medios_pagos_pago")
public class MedioPagoPago {

    @Id
    private Long idMedioPago;

    @Column(name = "cedula_cliente", nullable = false)
    private String cedulaCliente;

    @Column(name = "tipo_medio_pago", nullable = false)
    private String tipoMedioPago;   // TARJETA o UTE

    @Column(nullable = false)
    private boolean predeterminado;

    public MedioPagoPago() {}

    public MedioPagoPago(String cedulaCliente, Long idMedioPago,
                          String tipoMedioPago, boolean predeterminado) {
        this.idMedioPago = idMedioPago;
        this.cedulaCliente = cedulaCliente;
        this.tipoMedioPago = tipoMedioPago;
        this.predeterminado = predeterminado;
    }

    public Long getIdMedioPago() { return idMedioPago; }
    public void setIdMedioPago(Long idMedioPago) { this.idMedioPago = idMedioPago; }
    public String getCedulaCliente() { return cedulaCliente; }
    public void setCedulaCliente(String cedulaCliente) { this.cedulaCliente = cedulaCliente; }
    public String getTipoMedioPago() { return tipoMedioPago; }
    public void setTipoMedioPago(String tipoMedioPago) { this.tipoMedioPago = tipoMedioPago; }
    public boolean isPredeterminado() { return predeterminado; }
    public void setPredeterminado(boolean predeterminado) { this.predeterminado = predeterminado; }
}
