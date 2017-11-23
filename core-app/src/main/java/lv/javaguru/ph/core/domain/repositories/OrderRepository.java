package lv.javaguru.ph.core.domain.repositories;

import lv.javaguru.ph.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOneByMsisdn(String msisdn);
//
//    default Order getRequiredByLogin(String login) {
//        return findOneByLogin(login)
//                .orElseThrow(() -> createValidationException(OCSPResponse.ResponseStatus.NOT_FOUND)
//                        .with(createValidationError()
//                                .withField("login")
//                                .withErrorCode("invalid.value")).build());
//    }
}
