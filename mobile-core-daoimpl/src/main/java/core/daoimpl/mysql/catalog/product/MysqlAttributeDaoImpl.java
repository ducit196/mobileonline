package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.AttributeDao;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Attribute;

import java.sql.*;

public class MysqlAttributeDaoImpl implements AttributeDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    private static MysqlAttributeDaoImpl ourInstance = new MysqlAttributeDaoImpl();

    public static MysqlAttributeDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAttributeDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public Attribute getById(int id) {
        String sql = "CALL PROC_ATTRIBUTE_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                return new Attribute(Integer.parseInt(rs.getString(1)), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
