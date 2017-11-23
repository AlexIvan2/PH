package lv.javaguru.ph.core.api.orders;

import lv.javaguru.ph.core.api.DomainCommand;

public class GetOrderCommand implements DomainCommand<GetOrderResult> {

    private Long orderId;

    public GetOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

}
