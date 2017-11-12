package lv.javaguru.ph.core.handlers.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.orders.GetAllOrdersCommand;
import lv.javaguru.ph.core.api.orders.GetAllOrdersResult;
import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.handlers.DomainCommandHandler;
import lv.javaguru.ph.core.services.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class GetAllOrdersCommandHandler
        implements DomainCommandHandler<GetAllOrdersCommand, GetAllOrdersResult> {

    @Autowired private OrderService orderService;
    @Autowired private OrderConverter orderConverter;


    @Override
    public GetAllOrdersResult execute(GetAllOrdersCommand command) {
        List<Order> orders;
        if(command.getMsisdn().isEmpty()) {
            orders = orderService.getAll();
        } else {
            orders = orderService.get(command.getMsisdn());
        }
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order order : orders) {
            ordersDTO.add(orderConverter.convert(order));
        }
        return new GetAllOrdersResult(ordersDTO);
    }


    @Override
    public Class getCommandType() {
        return GetAllOrdersCommand.class;
    }

}
