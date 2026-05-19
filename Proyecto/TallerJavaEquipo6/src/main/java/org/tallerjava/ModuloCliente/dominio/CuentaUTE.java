package org.tallerjava.ModuloCliente.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas_ute")
public class CuentaUTE extends MedioPago {

    private String numeroCuenta;

    public CuentaUTE() {
        super();
    }

    public CuentaUTE(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String describir() {
        return "Cuenta UTE Nro. " + numeroCuenta;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
}
