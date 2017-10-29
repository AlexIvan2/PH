package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.services.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderService;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
class UndoOrderCommandHandler
        implements DomainCommandHandler<UndoOrderCommand, UndoOrderResult> {

    @Autowired private OrderService orderService;

    @Override
    public UndoOrderResult execute(UndoOrderCommand command) {
        List<Order> orders = orderService.get(command.getMsisdn());
        Order orderForUndo;
        Date now = new Date();
        for (Order order : orders) {
            if (now.before(order.getActivationDate())) {
                orderForUndo = order;
                orderService.undo(orderForUndo);
            }
        }
        return new UndoOrderResult();
    }

    @Override
    public Class getCommandType() {
        return UndoOrderCommand.class;
    }

}
