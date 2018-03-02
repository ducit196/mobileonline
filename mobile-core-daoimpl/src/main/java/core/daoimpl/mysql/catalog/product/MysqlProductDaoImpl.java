package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.ProductDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlProductDaoImpl implements ProductDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlProductDaoImpl ourInstance = new MysqlProductDaoImpl();

    public static MysqlProductDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlProductDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
