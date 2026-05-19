package org.tallerjava.ModuloCliente.Interface.remota.rest.dto;

import org.tallerjava.ModuloCliente.dominio.*;

import java.time.LocalDate;

public class MedioPagoDTO {

    private String tipo;                  // TARJETA o UTE

    // Solo para Tarjeta
    private String numero;
    private String titular;
    private String fechaVencimiento;      // ejemplo 2027-12-01
    private String digitoVerificacion;
    private String tipoTarjeta;           // VISA, MASTERCARD, OCA, AMEX

    // Solo para CuentaUTE
    private String numeroCuenta;

    public MedioPagoDTO() {}

    /*
      convierte el DTO al objeto de dominio correspondiente.
      lee el campo tipo y decide que subclase construir.
     */
    public MedioPago build() {
        if ("UTE".equalsIgnoreCase(tipo)) {
            if (numeroCuenta == null || numeroCuenta.isBlank()) {
                throw new IllegalArgumentException(
                        "Cuenta UTE requiere numeroCuenta");
            }
            return new CuentaUTE(numeroCuenta);
        }

        if ("TARJETA".equalsIgnoreCase(tipo)) {
            if (numero == null || tipoTarjeta == null || fechaVencimiento == null) {
                throw new IllegalArgumentException(
                        "Tarjeta requiere numero, tipoTarjeta y fechaVencimiento");
            }
            Tarjeta tarjeta = new Tarjeta(
                    numero,
                    titular,
                    LocalDate.parse(fechaVencimiento),
                    digitoVerificacion,
                    TipoTarjeta.valueOf(tipoTarjeta.toUpperCase())
            );
            return tarjeta;
        }

        throw new IllegalArgumentException("Tipo de medio de pago no reconocido: " + tipo);
    }


     // convierte objeto dominio a DTO
    public static MedioPagoDTO convertirDTO(MedioPago medioPago) {
        MedioPagoDTO dto = new MedioPagoDTO();

        if (medioPago instanceof Tarjeta tarjeta) {
            dto.setTipo("TARJETA");
            dto.setTitular(tarjeta.getTitular());
            dto.setTipoTarjeta(tarjeta.getTipoTarjeta().name());
            dto.setFechaVencimiento(tarjeta.getFechaVencimiento().toString());
            // Solo exponemos ultimos 4 dígitos — requerimiento de seguridad de la letra
            dto.setNumero("**** **** **** " + tarjeta.ultimosCuatroDigitos());
        } else if (medioPago instanceof CuentaUTE ute) {
            dto.setTipo("UTE");
            dto.setNumeroCuenta(ute.getNumeroCuenta());
        }

        return dto;
    }

    // getters y setters

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDigitoVerificacion() { return digitoVerificacion; }
    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(String tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
}
