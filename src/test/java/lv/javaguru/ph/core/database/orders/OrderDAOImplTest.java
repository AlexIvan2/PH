package lv.javaguru.ph.core.database.orders;

import lv.javaguru.ph.core.domain.Order;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.ph.core.domain.OrderBuilder.createOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class OrderDAOImplTest extends DatabaseHibernateTest {

    @Test
    @Transactional
    public void testCreateClient() {
        Order order = createOrder()
                .withMsisdn("login")
                .withRoutingNumber("password").build();
        assertThat(order.getId(), is(nullValue()));
        orderDAO.create(order);
        assertThat(order.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        Order order = createOrder()
                .withMsisdn("login")
                .withRoutingNumber("password").build();
        orderDAO.create(order);
        Order orderFromDb = orderDAO.getById(order.getId());
        assertThat(orderFromDb, is(notNullValue()));
    }

}