package core.daoimpl.factory;

import core.dao.AccountDao;
import core.dao.CustomerDao;

/**
 * @author DucBa
 */
public abstract class DAOFactory {
    public static final int ORACLE = 1;
    public static final int CLOUDSCAPE = 2;
    public static final int SQLSERVER = 3;
    public static final int MYSQL = 4;

    //select database
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MysqlDAOFactory();
            default:
                return null;
        }
    }

    //list of defined dao
    public abstract CustomerDao getCustomerDao();

    public abstract AccountDao getAccountDao();
}
