package lv.javaguru.ph.core.services.users;

import lv.javaguru.ph.core.domain.Order;

import java.util.Date;

public interface OrderFactory {

    Order create(String msisdn, String routingNumber, Date activationDate);

}
