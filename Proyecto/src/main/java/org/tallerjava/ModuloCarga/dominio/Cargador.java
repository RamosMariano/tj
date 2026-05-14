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

    public Cargador(TipoCargador tipo, boolean tieneCable, TipoConector tipoConector, EstadoCargador estado, LocalDateTime tiempoEstimadoFinalizacion, LocalDate fechaEstimadaReparacion, int potenciaMin) {
        this.tipo = tipo;
        this.tieneCable = tieneCable;
        this.tipoConector = tipoConector;
        this.estado = estado;
        this.tiempoEstimadoFinalizacion = tiempoEstimadoFinalizacion;
        this.fechaEstimadaReparacion = fechaEstimadaReparacion;
        this.potenciaMin = potenciaMin;
    }

    public TipoCargador getTipo() {
        return tipo;
    }

    public void setTipo(TipoCargador tipo) {
        this.tipo = tipo;
    }

    public boolean isTieneCable() {
        return tieneCable;
    }

    public void setTieneCable(boolean tieneCable) {
        this.tieneCable = tieneCable;
    }

    public TipoConector getTipoConector() {
        return tipoConector;
    }

    public void setTipoConector(TipoConector tipoConector) {
        this.tipoConector = tipoConector;
    }

    public EstadoCargador getEstado() {
        return estado;
    }

    public void setEstado(EstadoCargador estado) {
        this.estado = estado;
    }

    public LocalDateTime getTiempoEstimadoFinalizacion() {
        return tiempoEstimadoFinalizacion;
    }

    public void setTiempoEstimadoFinalizacion(LocalDateTime tiempoEstimadoFinalizacion) {
        this.tiempoEstimadoFinalizacion = tiempoEstimadoFinalizacion;
    }

    public LocalDate getFechaEstimadaReparacion() {
        return fechaEstimadaReparacion;
    }

    public void setFechaEstimadaReparacion(LocalDate fechaEstimadaReparacion) {
        this.fechaEstimadaReparacion = fechaEstimadaReparacion;
    }

    public int getPotenciaMin() {
        return potenciaMin;
    }

    public void setPotenciaMin(int potenciaMin) {
        this.potenciaMin = potenciaMin;
    }
}
