package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.commands.DomainCommandResult;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;

public class UpdateOrderResult implements DomainCommandResult {

    private OrderDTO order;

    public UpdateOrderResult(OrderDTO order) {
        this.order = order;
    }

    public OrderDTO getOrder() {
        return order;
    }

}
