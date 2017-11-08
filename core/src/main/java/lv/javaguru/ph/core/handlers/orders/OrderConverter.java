package lv.javaguru.ph.core.handlers.orders;

import lv.javaguru.ph.common.dtos.OrderDTO;
import lv.javaguru.ph.core.domain.Order;
import org.springframework.stereotype.Component;

import static lv.javaguru.ph.common.dtos.OrderDTOBuilder.createOrderDTO;


@Component
class OrderConverter {

    public OrderDTO convert(Order order) {
        return createOrderDTO()
                .withId(order.getId())
                .withMsisdn(order.getMsisdn())
                .withRoutingNumber(order.getRoutingNumber())
                .withActivationDate(order.getActivationDate())
                .build();
    }


}
