package core.daoimpl.mysql.common;

import core.dao.common.AddressDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.common.Address;

import java.sql.*;

public class MysqlAddressDaoImpl implements AddressDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    private static MysqlAddressDaoImpl ourInstance = new MysqlAddressDaoImpl();

    public static MysqlAddressDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAddressDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public Address getById(int addressId) {
        String sql = "CALL PROC_ADDRESS_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, addressId);
            rs = cs.executeQuery();
            while (rs.next()) {
                return new Address(Integer.parseInt(rs.getString(1)), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
