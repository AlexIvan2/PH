package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.database.OrderDAO;
import lv.javaguru.ph.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static lv.javaguru.ph.core.domain.OrderBuilder.createOrder;

@Component
class OrderFactoryImpl implements OrderFactory {

    @Autowired private OrderValidator orderValidator;
    @Autowired private OrderDAO orderDAO;


    @Override
    public Order create(String msisdn, String routingNumber, Date activationDate) {
        orderValidator.validate(msisdn, routingNumber, activationDate);
        Order order = createOrder()
                .withMsisdn(msisdn)
                .withRoutingNumber(routingNumber)
                .withActivationDate(activationDate)
                .build();
        orderDAO.create(order);
        return order;
    }

}
