package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.database.OrderDAO;
import lv.javaguru.ph.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
class OrderServiceImpl implements OrderService {

    @Autowired private OrderDAO orderDAO;
    @Autowired private OrderValidator orderValidator;


    @Override
    public Order update(Long orderId,
                        String msisdn,
                        String routingNumber,
                        Date activationDate) {
        orderValidator.validate(msisdn, routingNumber, activationDate);
        //TODO:Add action validation
        Order order = get(orderId);
        order.setMsisdn(msisdn);//TODO:msisdn?
        order.setRoutingNumber(routingNumber);
        order.setActivationDate(activationDate);
        return order;
    }

    @Override
    public Order get(Long orderId) {
        return orderDAO.getRequired(orderId);
    }

}
