package lv.javaguru.ph.core.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(generator = "orders_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", allocationSize = 1)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="msisdn", nullable = false)
    private String msisdn;

    @Column(name="routing_number", nullable = false)
    private String routingNumber;

    @Column(name="activation_date")
    private Date activationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }
}
