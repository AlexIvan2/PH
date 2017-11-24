package lv.javaguru.ph.core.commands.orders;


import lv.javaguru.ph.core.api.DomainCommand;

import java.util.Date;

public class UpdateOrderCommand implements DomainCommand<UpdateOrderResult> {

    private Long orderId;

    private String msisdn;
    private String routingNumber;
    private Date activationDate;


    public UpdateOrderCommand(Long orderId,
                              String msisdn,
                              String routingNumber,
                              Date activationDate) {
        this.orderId = orderId;
        this.msisdn = msisdn;
        this.routingNumber = routingNumber;
        this.activationDate = activationDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public Date getActivationDate() {
        return activationDate;
    }
}
