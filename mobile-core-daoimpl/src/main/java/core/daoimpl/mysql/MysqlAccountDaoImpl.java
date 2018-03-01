package core.daoimpl.mysql;

import core.dao.AccountDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlAccountDaoImpl implements AccountDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlAccountDaoImpl ourInstance = new MysqlAccountDaoImpl();

    public static MysqlAccountDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAccountDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public void add() {
        String sql = "INSERT INTO tets() VALUES('1996','1997')";
        try {
            pr = con.prepareStatement(sql);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
