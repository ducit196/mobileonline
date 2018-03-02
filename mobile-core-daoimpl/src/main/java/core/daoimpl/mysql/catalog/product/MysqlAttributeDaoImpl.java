package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.AttributeDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlAttributeDaoImpl implements AttributeDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlAttributeDaoImpl ourInstance = new MysqlAttributeDaoImpl();

    public static MysqlAttributeDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAttributeDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

}
