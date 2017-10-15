package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import lv.javaguru.ph.core.services.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetOrderCommandHandler
        implements DomainCommandHandler<GetOrderCommand, GetOrderResult> {

    @Autowired private OrderService orderService;
    @Autowired private OrderConverter orderConverter;


    @Override
    public GetOrderResult execute(GetOrderCommand command) {
        Order order = orderService.get(command.getOrderId());
        OrderDTO orderDTO = orderConverter.convert(order);
        return new GetOrderResult(orderDTO);
    }

    @Override
    public Class getCommandType() {
        return GetOrderCommand.class;
    }

}
