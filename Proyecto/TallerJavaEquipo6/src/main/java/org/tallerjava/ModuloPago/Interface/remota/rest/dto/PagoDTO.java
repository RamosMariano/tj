package org.tallerjava.ModuloPago.Interface.remota.rest.dto;

import org.tallerjava.ModuloPago.dominio.*;

public class PagoDTO {

    private Long id;
    private int importe;
    private LocalDate fecha;
    private LocalDateTime hora;

    public PagoDTO() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getImporte() { return importe; }

    public void setImporte(int importe) { this.importe = importe; }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalDateTime getHora() { return hora; }

    public void setHora(LocalDateTime hora) { this.hora = hora; }

    public Pago build(){
        Pago pago = new Pago(id,importe,fecha,hora);
        return pago;
    }

    public static PagoDTO convertirDTO(Pago pago){
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setImporte(pago.getImporte());
        dto.setFecha(pago.getFecha());
        dto.setHora(pago.getHora());
        return dto;
    }
}
