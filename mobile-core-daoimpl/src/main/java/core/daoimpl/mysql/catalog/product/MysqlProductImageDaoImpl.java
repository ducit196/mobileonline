package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.ProductImageDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlProductImageDaoImpl implements ProductImageDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlProductImageDaoImpl ourInstance = new MysqlProductImageDaoImpl();

    public static MysqlProductImageDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlProductImageDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
