package core.daoimpl.mysql.shopping_cart;

import core.dao.shopping_cart.ShoppingCartDao;
import core.dao.shopping_cart.ShoppingCartItemDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Product;
import core.dto.model.shoppingcart.ShoppingCart;
import core.dto.model.shoppingcart.ShoppingCartItem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MysqlShoppingCartDaoImpl implements ShoppingCartDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    private static MysqlShoppingCartDaoImpl ourInstance = new MysqlShoppingCartDaoImpl();

    public static MysqlShoppingCartDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlShoppingCartDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public void insert(ShoppingCart shoppingCart, Date createOn, int customerId) {
        String sql = "CALL PROC_SHOPPING_CART_INSERT(?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, shoppingCart.getId());
            cs.setDate(2, new java.sql.Date(createOn.getTime()));
            cs.setInt(3, 0);
            cs.setInt(4, customerId);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //save cart detail
        ShoppingCartItemDao shoppingCartItemDao = daoFactory.getShoppingCartItemDao();
        Set<Map.Entry<Integer, ShoppingCartItem>> entries = shoppingCart.getShoppingCart().entrySet();
        for (Map.Entry<Integer, ShoppingCartItem> entry : entries) {
            shoppingCartItemDao.insert(entry.getValue(), shoppingCart.getId());
        }
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ShoppingCartDao shoppingCartDao = daoFactory.getShoppingCartDao();
        ShoppingCart shoppingCart = new ShoppingCart();
        HashMap<Integer, ShoppingCartItem> longShoppingCartItemHashMap = new HashMap<Integer, ShoppingCartItem>();
        longShoppingCartItemHashMap.put(1, new ShoppingCartItem(new Product(1), "red", 1));
        shoppingCart.setShoppingCart(longShoppingCartItemHashMap);
        shoppingCart.setId(3);
        shoppingCartDao.insert(shoppingCart, new Date(), 1);
    }
}
