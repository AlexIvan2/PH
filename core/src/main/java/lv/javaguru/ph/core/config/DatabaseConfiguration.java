package lv.javaguru.ph.core.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("lv.javaguru.ph")
@EnableTransactionManagement
@EntityScan("lv.javaguru.ph")
public class DatabaseConfiguration {

}

