package lv.javaguru.ph.core.handlers.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.orders.UpdateOrderCommand;
import lv.javaguru.ph.core.api.orders.UpdateOrderResult;
import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.handlers.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateOrderCommandHandler
        implements DomainCommandHandler<UpdateOrderCommand, UpdateOrderResult> {

    @Autowired private OrderService orderService;
    @Autowired private OrderConverter orderConverter;

    @Override
    public UpdateOrderResult execute(UpdateOrderCommand command) {
        Order order = orderService.update(
                command.getOrderId(),
                command.getMsisdn(),
                command.getRoutingNumber(),
                command.getActivationDate()
        );
        OrderDTO orderDTO = orderConverter.convert(order);
        return new UpdateOrderResult(orderDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateOrderCommand.class;
    }

}
