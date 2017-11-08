package lv.javaguru.ph.core.services.users;

import lv.javaguru.ph.core.domain.Order;

public interface OrderActionValidator {

    Order validateUndoAction(String msisdn);

}
