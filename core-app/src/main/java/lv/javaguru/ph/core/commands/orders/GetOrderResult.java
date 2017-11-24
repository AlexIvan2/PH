package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.commands.DomainCommandResult;

public class GetOrderResult implements DomainCommandResult {

    private OrderDTO order;

    public GetOrderResult(OrderDTO order) {
        this.order = order;
    }

    public OrderDTO getOrder() {
        return order;
    }

}
