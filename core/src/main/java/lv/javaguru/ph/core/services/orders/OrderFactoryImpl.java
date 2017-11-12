package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static lv.javaguru.ph.core.domain.builders.OrderBuilder.createOrder;


@Component
class OrderFactoryImpl implements OrderFactory {

    @Autowired private OrderValidator orderValidator;
    @Autowired private OrderRepository orderRepository;


    @Override
    public Order create(String msisdn, String routingNumber, Date activationDate) {
        orderValidator.validate(msisdn, routingNumber, activationDate);
        Order order = createOrder()
                .withMsisdn(msisdn)
                .withRoutingNumber(routingNumber)
                .withActivationDate(activationDate)
                .build();
        orderRepository.save(order);
        return order;
    }

}
