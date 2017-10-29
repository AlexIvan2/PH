package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.domain.Order;

import java.util.Date;
import java.util.List;


public interface OrderService {

    Order update(Long orderId,
                 String msisdn,
                 String routingNumber,
                 Date activationDate);

    Order get(Long OrderId);

    List<Order> getAll();

    List<Order> get(String msisdn);

    void undo(Order order);

}
