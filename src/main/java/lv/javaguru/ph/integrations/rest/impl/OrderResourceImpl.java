package lv.javaguru.ph.integrations.rest.impl;

import lv.javaguru.ph.core.commands.orders.CreateOrderCommand;
import lv.javaguru.ph.core.commands.orders.CreateOrderResult;
import lv.javaguru.ph.core.commands.orders.GetOrderCommand;
import lv.javaguru.ph.core.commands.orders.GetOrderResult;
import lv.javaguru.ph.core.services.CommandExecutor;
import lv.javaguru.ph.integrations.rest.api.RESTResource;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class OrderResourceImpl {

    @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        CreateOrderCommand command = new CreateOrderCommand(
                orderDTO.getMsisdn(), orderDTO.getRoutingNumber(), orderDTO.getActivationDate()
        );
        CreateOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getOrder());
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> get(@PathVariable("orderId") Long orderId) {
        GetOrderCommand command = new GetOrderCommand(orderId);
        GetOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getOrder());
    }

}
