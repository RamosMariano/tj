package org.tallerjava.ModuloCliente.dominio;

public class ClienteProfesional extends Cliente{
    //atributos
    private float porcentajeDescuento;
    private TipoProfesional tipo;

    //constructor
    public ClienteProfesional(String cedula, String nombreCompleto, String telefono, String contrasenia, float porcentajeDescuento, TipoProfesional tipo) {
        super(cedula, nombreCompleto, telefono, contrasenia);
        this.porcentajeDescuento = porcentajeDescuento;
        this.tipo = tipo;
    }
}
