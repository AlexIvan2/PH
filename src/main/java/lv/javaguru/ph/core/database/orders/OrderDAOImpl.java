package lv.javaguru.ph.core.database.orders;

import lv.javaguru.ph.core.database.OrderDAO;
import lv.javaguru.ph.core.domain.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class OrderDAOImpl extends CRUDOperationDAOImpl<Order, Long> implements OrderDAO {


    @Override
    public List<Order> getByMsisdn(String msisdn){
        List<Order> allOrders = getAll();
        List<Order> orders = new ArrayList<>();
        for (Order order :allOrders) {
            if (order.getMsisdn().equals(msisdn))
                orders.add(order);
        }
        return orders;
    }

}
