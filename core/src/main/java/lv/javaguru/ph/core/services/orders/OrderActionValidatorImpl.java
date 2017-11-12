package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Component
class OrderActionValidatorImpl implements OrderActionValidator {

    @Autowired
    private OrderService orderService;

    @Override
    public Order validateUndoAction (String msisdn) {
        Order orderForUndo = null;
        List<Order> orders = orderService.get(msisdn);
        if (orders.isEmpty()){
            throw new IllegalArgumentException("Order with such MSISDN not found");
        } else {
            Date now = new Date();
            for (Order order : orders) {
                if (now.before(order.getActivationDate())) {
                    orderForUndo = order;
                }
            }
        }
        return orderForUndo;
    }
}
