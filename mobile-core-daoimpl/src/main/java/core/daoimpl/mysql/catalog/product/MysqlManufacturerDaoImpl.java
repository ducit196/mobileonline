package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.ManufacturerDao;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Manufacturer;

import java.sql.*;

public class MysqlManufacturerDaoImpl implements ManufacturerDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    private static MysqlManufacturerDaoImpl ourInstance = new MysqlManufacturerDaoImpl();

    public static MysqlManufacturerDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlManufacturerDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public Manufacturer getById(int id) {
        String sql = "CALL PROC_MANUFACTURER_GET_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                return new Manufacturer(Integer.parseInt(rs.getString(1)), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
