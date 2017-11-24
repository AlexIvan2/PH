package lv.javaguru.ph.app.rest.controllers;


import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.CommandExecutor;
import lv.javaguru.ph.core.api.orders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RESTResource.API_PATH)
public class OrderResourceImpl {

    @Autowired
    private CommandExecutor commandExecutor;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        GetAllOrdersCommand command = new GetAllOrdersCommand();
        GetAllOrdersResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getAllOrders());
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> getById(@PathVariable("orderId") Long orderId) {
        GetOrderCommand command = new GetOrderCommand(orderId);
        GetOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getOrder());
    }

    @RequestMapping(value = "/orders/{msisdn}", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> getByMsisdn(@PathVariable("msisdn") String msisdn) {
        GetAllOrdersCommand command = new GetAllOrdersCommand(msisdn);
        GetAllOrdersResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getAllOrders());
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        CreateOrderCommand command = new CreateOrderCommand(
                orderDTO.getMsisdn(), orderDTO.getRoutingNumber(), orderDTO.getActivationDate()
        );
        CreateOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getOrder());
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> update(@PathVariable("orderId") Long orderId, @RequestBody OrderDTO orderDTO) {
        UpdateOrderCommand command = new UpdateOrderCommand(
                orderId, orderDTO.getMsisdn(), orderDTO.getRoutingNumber(), orderDTO.getActivationDate()
        );
        UpdateOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result.getOrder());
    }

    @RequestMapping(value = "/order/undo/{msisdn}", method = RequestMethod.GET)
    public ResponseEntity<UndoOrderResult> undo(@PathVariable("msisdn") String msisdn) {
        UndoOrderCommand command = new UndoOrderCommand(msisdn);
        UndoOrderResult result = commandExecutor.execute(command);
        return ResponseEntity.ok(result);
    }

}
