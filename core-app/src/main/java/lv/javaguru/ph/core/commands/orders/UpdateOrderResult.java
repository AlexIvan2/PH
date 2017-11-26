package lv.javaguru.ph.core.commands.orders;


import lv.javaguru.ph.common.dtos.OrderDTO;

public class UpdateOrderResult {

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
