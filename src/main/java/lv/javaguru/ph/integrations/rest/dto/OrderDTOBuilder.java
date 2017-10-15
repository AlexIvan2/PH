package lv.javaguru.ph.integrations.rest.dto;

import java.util.Date;

public class OrderDTOBuilder {

    private Long id;
    private String msisdn;
    private String routingNumber;
    private Date activationDate;


    private OrderDTOBuilder() {

    }

    public static OrderDTOBuilder createOrderDTO() {
        return new OrderDTOBuilder();
    }

    public OrderDTO build() {
        OrderDTO order = new OrderDTO();
        order.setId(id);
        order.setMsisdn(msisdn);
        order.setRoutingNumber(routingNumber);
        order.setActivationDate(activationDate);
        return order;
    }

    public OrderDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderDTOBuilder withMsisdn(String msisdn) {
        this.msisdn = msisdn;
        return this;
    }

    public OrderDTOBuilder withRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
        return this;
    }

    public OrderDTOBuilder withActivationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }



}
