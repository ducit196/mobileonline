package api.test;

import core.dao.customer.CustomerDao;
import core.daoimpl.factory.DAOFactory;

public class Test {

    @org.junit.Test
    public void test() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CustomerDao customerDao = daoFactory.getCustomerDao();
    }

}
