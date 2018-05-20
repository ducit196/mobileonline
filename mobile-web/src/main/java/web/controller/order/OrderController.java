package web.controller.order;

import core.dao.order.OrderDao;
import core.dao.order.OrderDetailDao;
import core.dao.shopping_cart.ShoppingCartDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.customer.Customer;
import core.dto.model.order.Order;
import core.dto.model.order.OrderDetail;
import core.dto.model.shoppingcart.ShoppingCart;
import core.dto.model.shoppingcart.ShoppingCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        OrderDao orderDao = daoFactory.getOrderDao();
        ShoppingCartDao shoppingCartDao = daoFactory.getShoppingCartDao();
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        Customer customer = (Customer) session.getAttribute("customer");
        Order order = new Order();
        order.setId((int) new Date().getTime());
        order.setDateOrderd(new Date());
        order.setPaymentType(1);
        order.setCustomer(customer);
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        for (Map.Entry<Integer, ShoppingCartItem> entry : shoppingCart.getShoppingCart().entrySet()) {
            listOrderDetail.add(new OrderDetail(entry.getValue().getProduct(), entry.getValue().getAttribute(),
                    entry.getValue().getQuantity()));
        }
        order.setListOrderDetail(listOrderDetail);
        orderDao.insert(order);
        shoppingCartDao.delete(shoppingCart.getId());
        session.setAttribute("shoppingCart", null);
        resp.sendRedirect("/views/fontend/home.jsp");
    }
}
