package lv.javaguru.ph.core.commands.orders;


import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.commands.DomainCommand;

import java.util.Date;

public class RegisterOrderCommand implements DomainCommand<RegisterOrderResult> {

    private OrderDTO orderDTO;

    public RegisterOrderCommand(OrderDTO userDTO) {
        this.orderDTO = orderDTO;
    }

    public OrderDTO getUserDTO() {
        return orderDTO;
    }

//    private String msisdn;
//    private String routingNumber;
//    private Date activationDate;
//
//
//    public RegisterOrderCommand(String msisdn,
//                                String routingNumber,
//                                Date activationDate) {
//        this.msisdn = msisdn;
//        this.routingNumber = routingNumber;
//        this.activationDate = activationDate;
//    }
//
//    public String getMsisdn() {
//        return msisdn;
//    }
//
//    public String getRoutingNumber() {
//        return routingNumber;
//    }
//
//    public Date getActivationDate() {
//        return activationDate;
//    }
}
