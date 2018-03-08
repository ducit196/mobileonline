package api.test;

import core.dao.common.AccountDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.common.Account;
import org.junit.Test;

import java.util.List;

public class AccountDaoTest {

    @Test
    public void getAllTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        AccountDao accountDao = daoFactory.getAccountDao();
        List<Account> list = accountDao.getAll();
        for (Account account : list) {
            System.out.println(account.getUsername());
            System.out.println(account.getEmail());
            System.out.println(account.getPassword());
        }
    }

    @Test
    public void getByIdTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        AccountDao accountDao = daoFactory.getAccountDao();
        List<Account> list = accountDao.getById(1);
        for (Account account : list) {
            System.out.println(account.getUsername());
            System.out.println(account.getEmail());
            System.out.println(account.getPassword());
        }
    }

}
