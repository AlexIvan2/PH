package lv.javaguru.ph.core.services.orders;


import lv.javaguru.ph.core.domain.Order;
import lv.javaguru.ph.core.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
class OrderServiceImpl implements OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderValidator orderValidator;


    @Override
    public Order update(Long orderId,
                        String msisdn,
                        String routingNumber,
                        Date activationDate) {
        orderValidator.validateNoMsisdn(routingNumber, activationDate);
        Order order = get(orderId);
        order.setRoutingNumber(routingNumber);
        order.setActivationDate(activationDate);
        return order;
    }

    @Override
    public Order get(Long orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> get(String msisdn){
        return orderRepository.findOneByMsisdn(msisdn);
    }

    @Override
    public void undo(Order order){
        orderRepository.delete(order);
    }

}
