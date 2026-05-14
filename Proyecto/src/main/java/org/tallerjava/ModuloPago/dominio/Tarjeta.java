package org.tallerjava.ModuloPago.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Tarjeta extends MedioPago{
    //atributos
    private String numero;
    private String digitoVerificacion;
    private LocalDate fechaVencimiento;
    private TipoTargeta tipo;
}
