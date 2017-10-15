package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.commands.DomainCommand;

public class GetOrderCommand implements DomainCommand<GetOrderResult> {

    private Long orderId;

    public GetOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

}
