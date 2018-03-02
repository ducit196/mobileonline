package core.daoimpl.mysql.common;

import core.dao.common.AccountDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlAccountDaoImpl implements AccountDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlAccountDaoImpl ourInstance = new MysqlAccountDaoImpl();

    public static MysqlAccountDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAccountDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
