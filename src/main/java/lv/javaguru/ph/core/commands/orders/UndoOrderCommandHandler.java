package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.services.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderActionValidator;
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
    @Autowired private OrderActionValidator orderActionValidator;

    @Override
    public UndoOrderResult execute(UndoOrderCommand command) {
        UndoOrderResult result = new UndoOrderResult();
        Order order = orderActionValidator.validateUndoAction(command.getMsisdn());
        if (order == null){
            result.setMessage("No future activations for this MSISDN");
        } else {
            orderService.undo(order);
            result.setMessage("Undo operation is complete");
        }
        return result;
    }

    @Override
    public Class getCommandType() {
        return UndoOrderCommand.class;
    }

}
