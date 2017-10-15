package lv.javaguru.ph.core.commands.orders;

import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.ph.integrations.rest.dto.OrderDTOBuilder.createOrderDTO;

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
