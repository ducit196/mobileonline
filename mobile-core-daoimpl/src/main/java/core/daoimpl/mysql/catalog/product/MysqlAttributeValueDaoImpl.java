package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.AttributeDao;
import core.dao.catalog.product.AttributeValueDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.AttributeValue;

import java.sql.*;

public class MysqlAttributeValueDaoImpl implements AttributeValueDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = null;

    private static MysqlAttributeValueDaoImpl ourInstance = new MysqlAttributeValueDaoImpl();

    public static MysqlAttributeValueDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAttributeValueDaoImpl() {
        con = MysqlDAOFactory.createConnection();
        daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    }

    public AttributeValue getById(int id) {
        AttributeDao attributeDao = daoFactory.getAttributeDao();
        String sql = "CALL PROC_ATTRIBUTE_VALUE_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                return new AttributeValue(Integer.parseInt(rs.getString(1)), rs.getString(2),
                        attributeDao.getById(Integer.parseInt(rs.getString(3))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
