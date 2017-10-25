package lv.javaguru.ph.integrations.rest.impl;

import lv.javaguru.ph.core.commands.orders.*;
import lv.javaguru.ph.core.services.CommandExecutor;
import lv.javaguru.ph.integrations.rest.api.RESTResource;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @RequestMapping(value = "/orders", method = RequestMethod.GET)
//    public ResponseEntity<List<OrderDTO>> getAllOrders() {
//        GetOrderCommand command =
//    }

    //TODO: Add action check
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> update(@PathVariable("orderId") Long orderId, @RequestBody OrderDTO orderDTO) {
        UpdateOrderCommand command = new UpdateOrderCommand(
                orderId, orderDTO.getMsisdn(), orderDTO.getRoutingNumber(), orderDTO.getActivationDate()
        );
        UpdateOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getOrder());
    }
//
//    @RequestMapping(value = "/orders/undo/{orderId}", method = RequestMethod.POST)
//    public ResponseEntity<OrderDTO> undo(@PathVariable("orderId") Long orderId, @RequestBody OrderDTO orderDTO) {
//
//    }

    //TODO: 1) Return the list of all orders. 2) Undo Order. (Delete if activation date in future)

}
