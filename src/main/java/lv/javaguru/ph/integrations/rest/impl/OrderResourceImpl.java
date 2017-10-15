package lv.javaguru.ph.integrations.rest.impl;

import lv.javaguru.ph.core.commands.orders.CreateOrderCommand;
import lv.javaguru.ph.core.commands.orders.CreateOrderResult;
import lv.javaguru.ph.core.commands.orders.GetOrderCommand;
import lv.javaguru.ph.core.commands.orders.GetOrderResult;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import lv.javaguru.ph.core.services.CommandExecutor;
import lv.javaguru.ph.integrations.rest.api.RESTResource;
import lv.javaguru.ph.integrations.rest.api.OrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class OrderResourceImpl implements OrderResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public OrderResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/orders")
    public OrderDTO create(OrderDTO orderDTO) {
        CreateOrderCommand command = new CreateOrderCommand(
                orderDTO.getMsisdn(), orderDTO.getRoutingNumber(), orderDTO.getActivationDate()
        );
        CreateOrderResult result = commandExecutor.execute(command);
        return result.getOrder();
    }

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/orders/{orderId}")
    public OrderDTO get(@PathParam("orderId") Long orderId) {
        GetOrderCommand command = new GetOrderCommand(orderId);
        GetOrderResult result = commandExecutor.execute(command);
        return result.getOrder();
    }

}
