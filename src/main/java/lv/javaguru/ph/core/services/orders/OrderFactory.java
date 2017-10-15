package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.domain.Order;

import java.util.Date;

public interface OrderFactory {

    Order create(String msisdn, String routingNumber, Date activationDate);

}
