package lv.javaguru.ph.core.api.orders;


import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.api.DomainCommandResult;

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
