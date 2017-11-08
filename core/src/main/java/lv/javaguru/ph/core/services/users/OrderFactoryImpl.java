package lv.javaguru.ph.core.services.users;

import lv.javaguru.ph.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;



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
