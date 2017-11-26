package lv.javaguru.ph.app.rest.controllers;


import lv.javaguru.ph.app.jms.JMSRequestProcessor;
import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSGetOrderByIdRequest;
import lv.javaguru.ph.core.api.jms.requests.orders.JMSRegisterOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/api")
public class OrderResourceImpl {

    @Autowired
    private JMSRequestProcessor jmsRequestProcessor;

//    @RequestMapping(value = "/orders", method = RequestMethod.GET)
//    public ResponseEntity<List<OrderDTO>> getAllOrders() {
//        GetAllOrdersCommand command = new GetAllOrdersCommand();
//        GetAllOrdersResult result = commandExecutor.execute(command);
//        return ResponseEntity.ok(result.getAllOrders());
//    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity> getById(@PathVariable("orderId") Long orderId) {
        JMSGetOrderByIdRequest jmsRequest = new JMSGetOrderByIdRequest();
        jmsRequest.setOrderId(orderId);
        return jmsRequestProcessor.process(jmsRequest);
    }

//    @RequestMapping(value = "/orders/{msisdn}", method = RequestMethod.GET)
//    public ResponseEntity<List<OrderDTO>> getByMsisdn(@PathVariable("msisdn") String msisdn) {
//        GetAllOrdersCommand command = new GetAllOrdersCommand(msisdn);
//        GetAllOrdersResult result = commandExecutor.execute(command);
//        return ResponseEntity.ok(result.getAllOrders());
//    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public DeferredResult<ResponseEntity> register(@RequestBody OrderDTO orderDTO) {
        JMSRegisterOrderRequest jmsRequest = new JMSRegisterOrderRequest();
        jmsRequest.setOrderDTO(orderDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

//    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.POST)
//    public ResponseEntity<OrderDTO> update(@PathVariable("orderId") Long orderId, @RequestBody OrderDTO orderDTO) {
//        UpdateOrderCommand command = new UpdateOrderCommand(
//                orderId, orderDTO.getMsisdn(), orderDTO.getRoutingNumber(), orderDTO.getActivationDate()
//        );
//        UpdateOrderResult result = commandExecutor.execute(command);
//        return ResponseEntity.ok(result.getOrder());
//    }
//
//    @RequestMapping(value = "/order/undo/{msisdn}", method = RequestMethod.GET)
//    public ResponseEntity<UndoOrderResult> undo(@PathVariable("msisdn") String msisdn) {
//        UndoOrderCommand command = new UndoOrderCommand(msisdn);
//        UndoOrderResult result = commandExecutor.execute(command);
//        return ResponseEntity.ok(result);
//    }

}
