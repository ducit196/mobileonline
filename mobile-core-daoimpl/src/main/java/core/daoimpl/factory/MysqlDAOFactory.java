package core.daoimpl.factory;

import core.commons.utils.LoadConfigFile;
import core.dao.common.AccountDao;
import core.dao.customer.CustomerDao;
import core.daoimpl.mysql.common.MysqlAccountDaoImpl;
import core.daoimpl.mysql.customer.MysqlCustomerDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAOFactory extends DAOFactory {

    public static final String PATH_FILE = "../../../db_config_mysql.properties";
    public static final String DRIVER = LoadConfigFile.loadConfigFile(PATH_FILE).get(0);
    public static final String DBURL = LoadConfigFile.loadConfigFile(PATH_FILE).get(1);
    public static final String USER = LoadConfigFile.loadConfigFile(PATH_FILE).get(2);
    public static final String PASS = LoadConfigFile.loadConfigFile(PATH_FILE).get(3);

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
