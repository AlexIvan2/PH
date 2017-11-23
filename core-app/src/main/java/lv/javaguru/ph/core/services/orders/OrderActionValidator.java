package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.domain.Order;

public interface OrderActionValidator {

    Order validateUndoAction(String msisdn);

}
