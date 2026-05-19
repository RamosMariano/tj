package org.tallerjava.ModuloCliente.Interface.remota.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import java.util.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.tallerjava.ModuloCliente.aplicacion.ServicioClientes;
import org.tallerjava.ModuloCliente.dominio.Cliente;
import org.tallerjava.ModuloCliente.dominio.MedioPago;
import org.tallerjava.ModuloCliente.Interface.remota.rest.dto.*;

@Path("/clientes")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteAPI {

    @Inject
    ServicioClientes servicioClientes;



     
    //cliente comun  
    // curl -X POST http://localhost:8080/TallerJavaEquipo6/api/clientes/registrar   -H "Content-Type: application/json"   -d '{"cedula":"12345678","nombreCompleto":"Juan Perez","telefono":"099123456","contrasena":"clave123","tipo":"COMUN"}'
    
    //cliente profesional
    // curl -X POST http://localhost:8080/TallerJavaEquipo6/api/clientes/registrar \   -H "Content-Type: application/json" \                                           -d '{"cedula":"99887766","nombreCompleto":"Maria Taxi","telefono":"098000111","contrasena":"pass456","tipo":"PROFESIONAL","tipoProfesional":"TAXI","porcentajeDescuento":15.0}'
     

    @POST
    @Path("/registrar")
    public Response registrar(ClienteDTO dto) {
        try {
            Cliente cliente = dto.build();
            servicioClientes.registrarCliente(cliente);
            return Response.status(Response.Status.CREATED).entity(cliente.getCedula()).build();
                                  
        } catch (IllegalArgumentException | IllegalStateException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
                            
        }
    }

   
    
    @POST
    @Path("/{cedula}/medioPago")
    public Response agregarMedioPago(@PathParam("cedula") String cedula,MedioPagoDTO dto) {
                                      
        try {
            MedioPago medioPago = dto.build();
            servicioClientes.altaMedioPago(cedula, medioPago);
            return Response.ok().entity("Medio de pago agregado correctamente").build();
                    
                    
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
                             
        }
    }

    @GET
    public Response obtenerClientes() {
        List<Cliente> clientes = servicioClientes.obtenerClientes();

        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clientesDTO.add(ClienteDTO.convertirDTO(cliente));
        }

        return Response.ok(clientesDTO).build();
    }

    @POST
    @Path("/{cedula}/reclamos")
    public Response realizarReclamo(@PathParam("cedula") String cedula, ReclamoDTO dto) {
                                     
        try {
            servicioClientes.realizarReclamo(cedula, dto.getComentario());
            return Response.status(Response.Status.CREATED).entity("Reclamo registrado correctamente").build();
                   
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
                    
                    
        }
    }
}
