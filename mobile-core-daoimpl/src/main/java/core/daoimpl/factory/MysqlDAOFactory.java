package core.daoimpl.factory;

import core.dao.AccountDao;
import core.dao.CustomerDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.mysql.MysqlAccountDaoImpl;
import core.daoimpl.mysql.MysqlCustomerDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost/test";
    public static final String USER = "root";
    public static final String PASS = "1234";

    public static Connection createConnection() {
        try {

            Class.forName(DRIVER);
            return DriverManager.getConnection(DBURL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomerDao getCustomerDao() {
        return MysqlCustomerDaoImpl.getInstance();
    }

    public AccountDao getAccountDao() {
        return MysqlAccountDaoImpl.getInstance();
    }
}
