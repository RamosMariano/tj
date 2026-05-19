package org.tallerjava.ModuloCliente.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_comunes")
public class ClienteComun extends Cliente {

    public ClienteComun() {
        super();
    }

    public ClienteComun(String cedula, String nombreCompleto, String telefono, String contrasena) {
        super(cedula, nombreCompleto, telefono, contrasena);
    }

    @Override
    public double aplicarDescuento(double importe) {
        return importe;
    }
}
