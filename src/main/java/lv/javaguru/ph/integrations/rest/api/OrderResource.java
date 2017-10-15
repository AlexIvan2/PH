package lv.javaguru.ph.integrations.rest.api;

import lv.javaguru.ph.integrations.rest.dto.OrderDTO;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface OrderResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/orders")
    OrderDTO create(OrderDTO orderDTO);

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/orders/{orderId}")
    OrderDTO get(@PathParam("orderId") Long orderId);

}
