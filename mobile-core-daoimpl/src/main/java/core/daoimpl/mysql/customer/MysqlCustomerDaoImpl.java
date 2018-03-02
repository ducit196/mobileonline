package core.daoimpl.mysql.customer;

import core.dao.customer.CustomerDao;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlCustomerDaoImpl implements CustomerDao{
    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlCustomerDaoImpl outInstance = new MysqlCustomerDaoImpl();

    public static MysqlCustomerDaoImpl getInstance() {
        return outInstance;
    }

    private MysqlCustomerDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    /*To do everything in here*/
}
