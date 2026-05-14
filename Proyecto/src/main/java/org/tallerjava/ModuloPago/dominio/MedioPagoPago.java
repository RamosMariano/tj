package org.tallerjava.ModuloPago.dominio;

public class MedioPagoPago {
    private long idCliente, idMedioPago;
    //private tipo

    public MedioPagoPago(long idCliente, long idMedioPago) {
        this.idCliente = idCliente;
        this.idMedioPago = idMedioPago;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(long idMedioPago) {
        this.idMedioPago = idMedioPago;
    }
}
