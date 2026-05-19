package org.tallerjava.ModuloCliente.dominio;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tarjetas")
public class Tarjeta extends MedioPago {

    private String numero;
    private String titular;
    private LocalDate fechaVencimiento;
    private String digitoVerificacion;

    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;

    public Tarjeta() {
        super();
    }

    public Tarjeta(String numero, String titular, LocalDate fechaVencimiento,
                   String digitoVerificacion, TipoTarjeta tipoTarjeta) {
        this.numero = numero;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
        this.digitoVerificacion = digitoVerificacion;
        this.tipoTarjeta = tipoTarjeta;
    }

    public boolean estaVigente() {  // para el modulo de pagos,  para que no se permita usar tarjetas vencidas
        return LocalDate.now().isBefore(fechaVencimiento) ||
               LocalDate.now().isEqual(fechaVencimiento);
    }

    public String ultimosCuatroDigitos() { // para el modulo de carga, para mostrar los medios de pago disponibles sin exponer todo el numero.
        if (numero == null) {
            return "No hay número registrado";
        }

        if (numero.length() < 4) {
            return "Número incompleto";
        }

        return numero.substring(numero.length() - 4);
    }

    @Override
    public String describir() {
        return tipoTarjeta + " terminada en " + ultimosCuatroDigitos();
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getDigitoVerificacion() { return digitoVerificacion; }
    public void setDigitoVerificacion(String digitoVerificacion) { this.digitoVerificacion = digitoVerificacion; }

    public TipoTarjeta getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }
}
