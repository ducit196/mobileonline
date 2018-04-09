package core.daoimpl.mysql.shopping_cart;

import core.dao.shopping_cart.ShoppingCartItemDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Product;
import core.dto.model.shoppingcart.ShoppingCartItem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlShoppingCartItemDaoImpl implements ShoppingCartItemDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    private static MysqlShoppingCartItemDaoImpl ourInstance = new MysqlShoppingCartItemDaoImpl();

    public static MysqlShoppingCartItemDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlShoppingCartItemDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public void insert(ShoppingCartItem shoppingCartItem, int shoppingCartId) {
        String sql = "CALL PROC_SHOPPING_CART_DETAIL_INSERT(?,?,?,?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, shoppingCartId);
            cs.setInt(2, shoppingCartItem.getProduct().getId());
            cs.setString(3, shoppingCartItem.getAttribute());
            cs.setInt(4, shoppingCartItem.getQuantity());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ShoppingCartItemDao shoppingCartItemDao = daoFactory.getShoppingCartItemDao();

        ShoppingCartItem red = new ShoppingCartItem(new Product(3), "red", 1);
        shoppingCartItemDao.insert(red, 1);
    }

}
