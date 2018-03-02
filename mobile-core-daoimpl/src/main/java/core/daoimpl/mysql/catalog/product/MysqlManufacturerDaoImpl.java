package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.ManufacturerDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlManufacturerDaoImpl implements ManufacturerDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlManufacturerDaoImpl ourInstance = new MysqlManufacturerDaoImpl();

    public static MysqlManufacturerDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlManufacturerDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
