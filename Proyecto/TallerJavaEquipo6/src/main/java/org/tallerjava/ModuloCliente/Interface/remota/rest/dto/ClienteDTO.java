package org.tallerjava.ModuloCliente.Interface.remota.rest.dto;

import org.tallerjava.ModuloCliente.dominio.*;

public class ClienteDTO {

    private String cedula;
    private String nombreCompleto;
    private String telefono;
    private String contrasena;
    private String tipo;                  // COMUN o PROFESIONAL

    // Solo para ClienteProfesional
    private String tipoProfesional;       // TAXI, UBER, CABIFY
    private Double porcentajeDescuento;

    public ClienteDTO() {}

    // convierte el dto a un objeto de dominio dependiendo del tipo
    public Cliente build() {
        if ("PROFESIONAL".equalsIgnoreCase(tipo)) {
            if (tipoProfesional == null || porcentajeDescuento == null) {
                throw new IllegalArgumentException(
                        "Cliente profesional requiere tipoProfesional y porcentajeDescuento");
            }
            return new ClienteProfesional(
                    cedula,
                    nombreCompleto,
                    telefono,
                    contrasena,
                    TipoProfesional.valueOf(tipoProfesional.toUpperCase()), //transforma el dato del string a mayusculas y lo convierte a enum para que no falle si el cliente lo manda en minuscula
                    porcentajeDescuento
            );
        }
        return new ClienteComun(cedula, nombreCompleto, telefono, contrasena);
    }

   
    // convierte un objeto cliente a un DTO de cliente 
    public static ClienteDTO convertirDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setCedula(cliente.getCedula());
        dto.setNombreCompleto(cliente.getNombreCompleto());
        dto.setTelefono(cliente.getTelefono());

        if (cliente instanceof ClienteProfesional prof) {
            dto.setTipo("PROFESIONAL");
            dto.setTipoProfesional(prof.getTipoProfesional().name());
            dto.setPorcentajeDescuento(prof.getPorcentajeDescuento());
        } else {
            dto.setTipo("COMUN");
        }
        return dto;
    }

    // getters y setters

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getTipoProfesional() { return tipoProfesional; }
    public void setTipoProfesional(String tipoProfesional) { this.tipoProfesional = tipoProfesional; }

    public Double getPorcentajeDescuento() { return porcentajeDescuento; }
    public void setPorcentajeDescuento(Double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }
}
