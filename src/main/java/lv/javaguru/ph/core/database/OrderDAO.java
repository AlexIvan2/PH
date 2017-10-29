package lv.javaguru.ph.core.database;

import lv.javaguru.ph.core.domain.Order;

import java.util.List;

public interface OrderDAO extends CRUDOperationDAO<Order, Long> {

    List<Order> getByMsisdn(String msisdn);

}
