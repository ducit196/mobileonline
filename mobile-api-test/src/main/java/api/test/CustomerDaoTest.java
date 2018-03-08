package api.test;

import core.dao.common.AccountDao;
import core.dao.customer.CustomerDao;
import core.daoimpl.factory.DAOFactory;
import org.junit.Test;

public class CustomerDaoTest {
    @Test
    public void test() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CustomerDao customerDao = daoFactory.getCustomerDao();
    }

}
