package org.tallerjava.ModuloCliente.Interface.evento.out;

public class ClienteRegistradoEvent {

    private final String cedula;
    private final String nombre;
    private final String tipo;   // comun o profesional — String, no enum

    public ClienteRegistradoEvent(String cedula, String nombre, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
}
