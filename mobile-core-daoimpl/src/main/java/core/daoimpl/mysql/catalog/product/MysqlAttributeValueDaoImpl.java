package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.AttributeValueDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlAttributeValueDaoImpl implements AttributeValueDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlAttributeValueDaoImpl ourInstance = new MysqlAttributeValueDaoImpl();

    public static MysqlAttributeValueDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAttributeValueDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
