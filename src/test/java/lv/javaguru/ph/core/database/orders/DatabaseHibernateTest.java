package lv.javaguru.ph.core.database.orders;

import lv.javaguru.ph.core.database.OrderDAO;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class DatabaseHibernateTest {

	@Autowired
	protected SessionFactory sessionFactory;

	@Autowired
	protected OrderDAO orderDAO;

}
