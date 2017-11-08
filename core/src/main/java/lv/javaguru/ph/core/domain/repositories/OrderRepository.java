package lv.javaguru.ph.core.domain.repositories;

import lv.javaguru.ph.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.security.provider.certpath.OCSPResponse;

import java.util.Optional;

import static lv.javaguru.ph.core.api.exceptons.ValidationErrorBuilder.createValidationError;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    Optional<Order> findOneByLogin(String login);
//
//    default Order getRequiredByLogin(String login) {
//        return findOneByLogin(login)
//                .orElseThrow(() -> createValidationException(OCSPResponse.ResponseStatus.NOT_FOUND)
//                        .with(createValidationError()
//                                .withField("login")
//                                .withErrorCode("invalid.value")).build());
//    }
}
