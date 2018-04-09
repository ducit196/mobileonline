package core.daoimpl.mysql.customer;

import core.dao.common.AccountDao;
import core.dao.common.AddressDao;
import core.dao.customer.CustomerDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.common.Address;
import core.dto.model.customer.Customer;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MysqlCustomerDaoImpl implements CustomerDao{
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private static MysqlCustomerDaoImpl outInstance = new MysqlCustomerDaoImpl();

    public static MysqlCustomerDaoImpl getInstance() {
        return outInstance;
    }

    private MysqlCustomerDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public void add(Customer customer) {

    }

    public void update(Customer customer) {
        String sql = "";
    }

    public Customer getById(int customerId) {
        AccountDao accountDao = daoFactory.getAccountDao();
        AddressDao addressDao = daoFactory.getAddressDao();
        String sql = "CALL PROC_CUSTOMER_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, customerId);
            rs = cs.executeQuery();
            while (rs.next()) {
                return new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), Integer.parseInt(rs.getString(5)),
                        new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(6)),
                        rs.getString(7), accountDao.getById(Integer.parseInt(rs.getString(8))),
                        addressDao.getById(Integer.parseInt(rs.getString(9))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer getByAccountId(int accountId) {
        AccountDao accountDao = daoFactory.getAccountDao();
        AddressDao addressDao = daoFactory.getAddressDao();
        String sql = "CALL PROC_CUSTOMER_SELECT_BY_ACCOUNT_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, accountId);
            rs = cs.executeQuery();
            while (rs.next()) {
                return new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
                        rs.getString(4), Integer.parseInt(rs.getString(5)),
                        new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(6)),
                        rs.getString(7), accountDao.getById(Integer.parseInt(rs.getString(8))),
                        addressDao.getById(Integer.parseInt(rs.getString(9))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CustomerDao customerDao = daoFactory.getCustomerDao();
        Customer customer = customerDao.getById(1);
        System.out.println(customer.getFirstName());
    }
    /*To do everything in here*/
}
