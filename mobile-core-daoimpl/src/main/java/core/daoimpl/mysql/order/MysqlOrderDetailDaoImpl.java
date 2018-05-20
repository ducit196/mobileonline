package core.daoimpl.mysql.order;

import core.dao.order.OrderDetailDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Product;
import core.dto.model.order.OrderDetail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlOrderDetailDaoImpl implements OrderDetailDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;


    private static MysqlOrderDetailDaoImpl ourInstance = new MysqlOrderDetailDaoImpl();

    public static MysqlOrderDetailDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlOrderDetailDaoImpl() {
        con = MysqlDAOFactory.createConnection();

    }

    public void insert(int orderId, OrderDetail orderDetail) {
        String sql = "CALL PROC_ORDER_DETAIL_INSERT(?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, orderId);
            cs.setInt(2, orderDetail.getProduct().getId());
            cs.setString(3, orderDetail.getAttribute());
            cs.setInt(4, orderDetail.getQuantity());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        OrderDetailDao orderDetailDao = daoFactory.getOrderDetailDao();

        Product product = new Product();
        product.setId(1);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setAttribute("Red");
        orderDetail.setQuantity(194678);
        orderDetailDao.insert(1, orderDetail);
    }
}
