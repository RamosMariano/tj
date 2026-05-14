package org.tallerjava.ModuloCliente.Interface.evento.out;

import org.tallerjava.ModuloCliente.dominio.TipoProfesional;

public class ClienteRegistradoEvent {
    private int idCliente;
    private String cedula, nombre;
    private TipoProfesional tipo;

    public ClienteRegistradoEvent(int idCliente, String cedula, String nombre, TipoProfesional tipo) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProfesional getTipo() {
        return tipo;
    }

    public void setTipo(TipoProfesional tipo) {
        this.tipo = tipo;
    }
}
