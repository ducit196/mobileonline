package web.controller.shopping_cart;

import core.dao.catalog.product.ProductDao;
import core.dao.shopping_cart.ShoppingCartDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.customer.Customer;
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
import java.util.Date;

@WebServlet("/ShoppingCartController")
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //dao init
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ProductDao productDao = daoFactory.getProductDao();
        ShoppingCartDao shoppingCartDao = daoFactory.getShoppingCartDao();
        HttpSession session = req.getSession();
        String url = "";
        //get đata
        int productId = 0;
        if (req.getParameter("productId") != null) {
            productId = Integer.parseInt(req.getParameter("productId"));
        }

        int quantity = 0;
        if (req.getParameter("quantity") != null) {
            quantity = Integer.parseInt(req.getParameter("quantity"));
        }


        String attribute = "";
        if (req.getParameter("attribute") != null) {
            attribute = req.getParameter("attribute");
        }

        String command = req.getParameter("command");

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        switch (command) {
            case "plus":
                ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
                shoppingCartItem.setProduct(productDao.getById(productId));
                shoppingCartItem.setQuantity(quantity);
                shoppingCartItem.setAttribute(attribute);
                shoppingCart.addToCart(productId, shoppingCartItem);
                url = "/views/fontend/home.jsp";
                break;
            case "save":
                Customer customer = null;
                if (session.getAttribute("customer") != null) {
                    customer = (Customer) session.getAttribute("customer");
                }
                if (customer != null) {
                    ShoppingCart shoppingCartSave = (ShoppingCart) session.getAttribute("shoppingCart");
                    shoppingCartSave.setId((int) new Date().getTime());
                    shoppingCartDao.insert(shoppingCartSave, new Date(), customer.getId());
                    url = "/views/fontend/home.jsp";
                } else {
                    url = "/views/fontend/login.jsp";
                }
                break;
        }
        resp.sendRedirect(url);
    }

}
