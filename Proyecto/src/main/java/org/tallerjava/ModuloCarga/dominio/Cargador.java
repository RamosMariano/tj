package org.tallerjava.ModuloCarga.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cargador {
    //atributos
    private TipoCargador tipo;
    private boolean tieneCable;
    private TipoConector tipoConector;
    private EstadoCargador estado;
    private LocalDateTime tiempoEstimadoFinalizacion;   //solo si estado=Ocupado
    private LocalDate fechaEstimadaReparacion;  //solo si estado=FueraDeServicio
    private int potenciaMin; //solo sit tipo=Rapido
}
