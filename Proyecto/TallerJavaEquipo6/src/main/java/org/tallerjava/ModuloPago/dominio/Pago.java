package org.tallerjava.ModuloPago.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int importe;
    private LocalDate fecha;
    private LocalDateTime hora;

    public Pago(Long id, int importe, LocalDate fecha, LocalDateTime hora) {
        this.id = id;
        this.importe = importe;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getImporte() { return importe; }
    public void setImporte(int importe) { this.importe = importe; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalDateTime getHora() { return hora; }
    public void setHora(LocalDateTime hora) { this.hora = hora; }
}
