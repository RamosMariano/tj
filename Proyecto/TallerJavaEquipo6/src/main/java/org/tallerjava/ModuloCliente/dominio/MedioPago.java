package org.tallerjava.ModuloCliente.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "medios_pago")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MedioPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean predeterminado;

    protected MedioPago() {}

    public abstract String describir();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean esPredeterminado() { return predeterminado; }
    public void setPredeterminado(boolean predeterminado) { this.predeterminado = predeterminado; }
}
