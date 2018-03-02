package core.daoimpl.mysql.shipping;

import core.dao.shipping.ShippingDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlShippingDaoImpl implements ShippingDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlShippingDaoImpl ourInstance = new MysqlShippingDaoImpl();

    public static MysqlShippingDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlShippingDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
