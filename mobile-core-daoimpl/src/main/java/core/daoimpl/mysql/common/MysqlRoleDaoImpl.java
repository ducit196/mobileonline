package core.daoimpl.mysql.common;

import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlRoleDaoImpl {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlRoleDaoImpl ourInstance = new MysqlRoleDaoImpl();

    public static MysqlRoleDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlRoleDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
