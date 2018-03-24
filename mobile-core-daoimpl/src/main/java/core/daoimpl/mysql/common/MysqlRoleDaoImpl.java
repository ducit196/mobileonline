package core.daoimpl.mysql.common;

import core.dao.common.RoleDao;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.common.Role;

import java.sql.*;

public class MysqlRoleDaoImpl implements RoleDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    private static MysqlRoleDaoImpl ourInstance = new MysqlRoleDaoImpl();

    public static MysqlRoleDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlRoleDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public Role getById(int id) {
        String sql = "CALL PROC_ROLE_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(Integer.parseInt(rs.getString(1)));
                role.setRole(Integer.parseInt(rs.getString(2)));
                role.setDescription(rs.getString(3));
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
