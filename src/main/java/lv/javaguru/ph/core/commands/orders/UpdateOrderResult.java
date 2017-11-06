package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.commands.DomainCommandResult;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;

public class UpdateOrderResult implements DomainCommandResult {

    private OrderDTO order;
    private String message;

    public UpdateOrderResult(OrderDTO order) {
        this.order = order;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
