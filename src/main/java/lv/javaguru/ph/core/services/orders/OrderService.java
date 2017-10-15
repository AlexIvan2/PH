package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.domain.Order;

import java.util.Date;


public interface OrderService {

    Order update(Long orderId,
                 String msisdn,
                 String routingNumber,
                 Date activationDate);

    Order get(Long OrderId);

}
