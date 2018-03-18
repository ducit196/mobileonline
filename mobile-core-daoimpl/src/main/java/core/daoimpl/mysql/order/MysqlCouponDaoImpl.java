package core.daoimpl.mysql.order;

import core.dao.order.CouponDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlCouponDaoImpl implements CouponDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlCouponDaoImpl ourInstance = new MysqlCouponDaoImpl();

    public static MysqlCouponDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlCouponDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
