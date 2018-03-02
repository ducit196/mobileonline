package core.daoimpl.mysql.common;

import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlAddressDaoImpl {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlAddressDaoImpl ourInstance = new MysqlAddressDaoImpl();

    public static MysqlAddressDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAddressDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
