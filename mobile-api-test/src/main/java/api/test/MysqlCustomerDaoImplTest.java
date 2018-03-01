package api.test;

import core.dao.AccountDao;
import core.dao.CustomerDao;
import core.daoimpl.factory.DAOFactory;
import org.junit.Test;

public class MysqlCustomerDaoImplTest {

    @Test
    public void addTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CustomerDao customerDao1 = daoFactory.getCustomerDao();
        CustomerDao customerDao2 = daoFactory.getCustomerDao();
        CustomerDao customerDao3 = daoFactory.getCustomerDao();
        CustomerDao customerDao4 = daoFactory.getCustomerDao();

        System.out.println(customerDao1.hashCode());
        System.out.println(customerDao2.hashCode());
        System.out.println(customerDao3.hashCode());
        System.out.println(customerDao4.hashCode());
    }

    @Test
    public void addAccountT() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        AccountDao accountDao1 = daoFactory.getAccountDao();
        AccountDao accountDao2 = daoFactory.getAccountDao();

        System.out.println(accountDao1.hashCode());
        System.out.println(accountDao2.hashCode());
    }

}
