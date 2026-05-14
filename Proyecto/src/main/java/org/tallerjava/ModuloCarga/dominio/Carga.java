package org.tallerjava.ModuloCarga.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Carga {
    //atributos
    private LocalDate fecha;
    private LocalDateTime horaInicio, horaFin, horaEstimadaFin;  //horaEstimadaFin: solo si estado=activa
    private float importeTotal, recargoPorDemora;
    private int porcentajeAvance;  //solo si estado=activa
    private EstadoCarga estado;
}
