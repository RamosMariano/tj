package org.tallerjava.ModuloPago.Interface.remota.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Path("/pagos")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagoAPI {

    @GET
    @Path("/{cedula}/listarPagos")
    public Response consultarPagos(@PathParam("cedula") String cedula, LocalDate fechaIni, LocalDate fechaFin){

    }
}
