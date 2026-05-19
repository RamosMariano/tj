package org.tallerjava.ModuloCliente.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_profesionales")
public class ClienteProfesional extends Cliente {

    @Enumerated(EnumType.STRING)
    private TipoProfesional tipoProfesional;

    private double porcentajeDescuento;

    public ClienteProfesional() {
        super();
    }

    public ClienteProfesional(String cedula, String nombreCompleto, String telefono,
                               String contrasena, TipoProfesional tipoProfesional,
                               double porcentajeDescuento) {
        super(cedula, nombreCompleto, telefono, contrasena);
        this.tipoProfesional = tipoProfesional;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double importe) {
        return importe * (1.0 - porcentajeDescuento / 100.0);
    }

    public TipoProfesional getTipoProfesional() { return tipoProfesional; }
    public void setTipoProfesional(TipoProfesional tipoProfesional) { this.tipoProfesional = tipoProfesional; }

    public double getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }
}
