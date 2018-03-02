package core.daoimpl.mysql.order;

import core.dao.order.OrderDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlOrderDaoImpl implements OrderDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlOrderDaoImpl ourInstance = new MysqlOrderDaoImpl();

    public static MysqlOrderDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlOrderDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
