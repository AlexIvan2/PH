package lv.javaguru.ph.core.domain;

import java.util.Date;

public class OrderBuilder {

    private Long id;
    private String msisdn;
    private String routingNumber;
    private Date activationDate;


    private OrderBuilder() {

    }

    public static OrderBuilder createOrder() {
        return new OrderBuilder();
    }

    public Order build() {
        Order order = new Order();
        order.setId(id);
        order.setMsisdn(msisdn);
        order.setRoutingNumber(routingNumber);
        order.setActivationDate(activationDate);
        return order;
    }

    public OrderBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withMsisdn(String msisdn) {
        this.msisdn = msisdn;
        return this;
    }

    public OrderBuilder withRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
        return this;
    }

    public OrderBuilder withActivationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

}
