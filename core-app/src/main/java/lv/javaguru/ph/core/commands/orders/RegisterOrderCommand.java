package lv.javaguru.ph.core.commands.orders;


import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.commands.DomainCommand;

import java.util.Date;

public class RegisterOrderCommand implements DomainCommand<RegisterOrderResult> {

    private OrderDTO orderDTO;

    public RegisterOrderCommand(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

}
