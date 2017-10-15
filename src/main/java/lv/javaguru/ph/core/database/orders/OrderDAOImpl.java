package lv.javaguru.ph.core.database.orders;

import lv.javaguru.ph.core.database.OrderDAO;
import lv.javaguru.ph.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
class OrderDAOImpl extends CRUDOperationDAOImpl<Order, Long> implements OrderDAO {

}
