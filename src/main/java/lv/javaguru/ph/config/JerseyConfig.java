package lv.javaguru.ph.config;

import lv.javaguru.ph.integrations.rest.impl.OrderResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(OrderResourceImpl.class);
    }

}
