package lv.javaguru.ph.core.services.orders;

import lv.javaguru.ph.core.database.OrderDAO;
import lv.javaguru.ph.core.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderFactoryImplTest {

    @Mock private OrderValidator orderValidator;
    @Mock private OrderDAO orderDAO;

    @InjectMocks
    private OrderFactory orderFactory = new OrderFactoryImpl();

    private static final String MSISDN = "37112345678";
    private static final String ROUTINGNUMBER = "12325";
    private static final Date ACTIVATIONDATE = null;


    @Test
    public void createShouldInvokeValidator() {
        orderFactory.create(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
        verify(orderValidator).validate(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(orderValidator).validate(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
        orderFactory.create(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
    }

    @Test
    public void createShouldPersistOrderAfterValidation() {
        Order order = orderFactory.create(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
        InOrder inOrder = inOrder(orderValidator, orderDAO);
        inOrder.verify(orderValidator).validate(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
        inOrder.verify(orderDAO).create(order);
    }

    @Test
    public void createShouldReturnNewOrder() {
        Order order = orderFactory.create(MSISDN, ROUTINGNUMBER, ACTIVATIONDATE);
        assertThat(order.getMsisdn(), is(MSISDN));
        assertThat(order.getRoutingNumber(), is(ROUTINGNUMBER));
        assertThat(order.getActivationDate(), is(ACTIVATIONDATE));
    }

}
