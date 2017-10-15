package lv.javaguru.ph.integrations.rest.clients;

import lv.javaguru.ph.integrations.rest.RESTResourceTest;
import lv.javaguru.ph.integrations.rest.dto.OrderDTO;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.util.Date;

import static lv.javaguru.ph.integrations.rest.dto.OrderDTOBuilder.createOrderDTO;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class OrderResourceImplTest extends RESTResourceTest {

    @Test
    public void createOrderTest() {
        OrderDTO order = orderResource.create(
                createOrderDTO()
                        .withMsisdn("371" + RandomStringUtils.random(8))
                        .withRoutingNumber(RandomStringUtils.random(5))
                        .build()
        );

        assertThat(order, is(notNullValue()));
        assertThat(order.getId(), is(notNullValue()));
    }

    @Test
    public void getOrderTest() {
        OrderDTO newOrder = orderResource.create(
                createOrderDTO()
                        .withMsisdn("371" + RandomStringUtils.random(8))
                        .withRoutingNumber(RandomStringUtils.random(5))
                        .build()
        );
        OrderDTO oldClient = orderResource.get(newOrder.getId());
        assertThat(newOrder.getId(), is(oldClient.getId()));
        assertThat(newOrder.getMsisdn(), is(oldClient.getMsisdn()));
        assertThat(newOrder.getRoutingNumber(), is(oldClient.getRoutingNumber()));
    }

}
