package org.tallerjava.ModuloCliente.Interface.evento.out;

public class MedioPagoAgregadoEvent {

    private final String cedulaCliente;
    private final Long idMedioPago;
    private final String tipoMedioPago;     // tarjeta o ute
    private final boolean predeterminado;

    public MedioPagoAgregadoEvent(String cedulaCliente, Long idMedioPago,
                                   String tipoMedioPago, boolean predeterminado) {
        this.cedulaCliente = cedulaCliente;
        this.idMedioPago = idMedioPago;
        this.tipoMedioPago = tipoMedioPago;
        this.predeterminado = predeterminado;
    }

    public String getCedulaCliente() { return cedulaCliente; }
    public Long getIdMedioPago() { return idMedioPago; }
    public String getTipoMedioPago() { return tipoMedioPago; }
    public boolean isPredeterminado() { return predeterminado; }
}
