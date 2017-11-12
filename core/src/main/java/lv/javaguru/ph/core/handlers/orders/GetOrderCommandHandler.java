package lv.javaguru.ph.core.handlers.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.orders.GetOrderCommand;
import lv.javaguru.ph.core.api.orders.GetOrderResult;
import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.handlers.DomainCommandHandler;
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
