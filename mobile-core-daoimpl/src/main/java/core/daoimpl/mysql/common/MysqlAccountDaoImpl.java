package core.daoimpl.mysql.common;

import core.dao.common.AccountDao;
import core.dao.common.RoleDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.common.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlAccountDaoImpl implements AccountDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);


    private static MysqlAccountDaoImpl ourInstance = new MysqlAccountDaoImpl();

    public static MysqlAccountDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlAccountDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public Account login(Account account) {
        RoleDao roleDao = daoFactory.getRoleDao();
        String sql = "CALL PROC_ACCOUNT_CHECK_LOGIN(?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setString(1, account.getUsername());
            cs.setString(2, account.getPassword());
            rs = cs.executeQuery();
            while (rs.next()) {
                Account account2 = new Account();
                account2.setUsername(rs.getString(2));
                account2.setEmail(rs.getString(3));
                account2.setPassword(rs.getString(4));
                account2.setRole(roleDao.getById(Integer.parseInt(rs.getString(5))));
                return account2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Account account) {
        String sql = "CALL PROC_ACCOUNT_INSERT(?,?,?,?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, (int) account.getId());
            cs.setString(2, account.getUsername());
            cs.setString(3, account.getEmail());
            cs.setString(4, account.getPassword());
            cs.setInt(5, (int) account.getRole().getId());
            cs.setDate(6, (Date) account.getCreateTime());
            if (account.isActive() == true) {
                cs.setInt(7, 1);
            } else {
                cs.setInt(7, 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAll() {
        List<Account> list = new ArrayList<Account>();
        String sql = "CALL PROC_ACCOUNT_SELECT_ALL";
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString(2));
                account.setEmail(rs.getString(3));
                account.setPassword(rs.getString(4));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account getById(int id) {
        String sql = "CALL PROC_ACCOUNT_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, (int) id);
            rs = cs.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString(2));
                account.setEmail(rs.getString(3));
                account.setPassword(rs.getString(4));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
