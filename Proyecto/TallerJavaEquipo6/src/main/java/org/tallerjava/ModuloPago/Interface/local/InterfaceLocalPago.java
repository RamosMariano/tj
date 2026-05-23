package org.tallerjava.ModuloPago.Interface.local;

public interface InterfaceLocalPago {
    boolean pagarCarga(String cedulaCliente, long importeCentavos, long idMedioPago);
}
