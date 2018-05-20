package core.daoimpl.mysql.order;

import core.dao.order.OrderDao;
import core.dao.order.OrderDetailDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Product;
import core.dto.model.customer.Customer;
import core.dto.model.order.Order;
import core.dto.model.order.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlOrderDaoImpl implements OrderDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    private static MysqlOrderDaoImpl ourInstance = new MysqlOrderDaoImpl();

    public static MysqlOrderDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlOrderDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public void insert(Order order) {
        String sql = "CALL PROC_ORDER_INSERT(?,?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, order.getId());
            cs.setDate(2, new java.sql.Date(order.getDateOrderd().getTime()));
            cs.setInt(3, order.getPaymentType());
            cs.setInt(4, order.getStatus());
            cs.setInt(5, order.getCustomer().getId());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        OrderDetailDao orderDetailDao = daoFactory.getOrderDetailDao();
        for (OrderDetail orderDetail : order.getListOrderDetail()) {
            orderDetailDao.insert(order.getId(), orderDetail);
        }
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        OrderDao orderDao = daoFactory.getOrderDao();
        Order order = new Order();
        order.setId(1996);
        order.setDateOrderd(new java.util.Date());
        order.setPaymentType(1);
        Customer customer = new Customer();
        customer.setId(1);
        order.setCustomer(customer);
        List<OrderDetail> list = new ArrayList<OrderDetail>();
        Product product = new Product();
        product.setId(1);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setAttribute("Red");
        orderDetail.setQuantity(194678);
        list.add(orderDetail);
        order.setListOrderDetail(list);
        orderDao.insert(order);
    }

}
