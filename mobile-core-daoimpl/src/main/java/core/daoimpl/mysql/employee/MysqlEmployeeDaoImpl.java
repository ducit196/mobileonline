package core.daoimpl.mysql.employee;

import core.dao.employee.EmployeeDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlEmployeeDaoImpl implements EmployeeDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlEmployeeDaoImpl ourInstance = new MysqlEmployeeDaoImpl();

    public static MysqlEmployeeDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlEmployeeDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
