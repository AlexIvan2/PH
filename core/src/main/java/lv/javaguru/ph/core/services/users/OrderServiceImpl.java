package lv.javaguru.ph.core.services.users;


import lv.javaguru.ph.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
class OrderServiceImpl implements OrderService {

    @Autowired private OrderDAO orderDAO;
    @Autowired private OrderValidator orderValidator;


    @Override
    public Order update(Long orderId,
                        String msisdn,
                        String routingNumber,
                        Date activationDate) {
        //orderValidator.validate(msisdn, routingNumber, activationDate);
        orderValidator.validateNoMsisdn(routingNumber, activationDate);
        Order order = get(orderId);
        //order.setMsisdn(msisdn);
        order.setRoutingNumber(routingNumber);
        order.setActivationDate(activationDate);
        return order;
    }

    @Override
    public Order get(Long orderId) {
        return orderDAO.getRequired(orderId);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public List<Order> get(String msisdn){
        return orderDAO.getByMsisdn(msisdn);
    }

    @Override
    public void undo(Order order){
        orderDAO.delete(order);
    }

}
