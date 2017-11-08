package lv.javaguru.ph.core.api.orders;


import lv.javaguru.ph.core.api.DomainCommand;

import java.util.Date;

public class CreateOrderCommand implements DomainCommand<CreateOrderResult> {

    private String msisdn;
    private String routingNumber;
    private Date activationDate;


    public CreateOrderCommand(String msisdn,
                              String routingNumber,
                              Date activationDate) {
        this.msisdn = msisdn;
        this.routingNumber = routingNumber;
        this.activationDate = activationDate;
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
