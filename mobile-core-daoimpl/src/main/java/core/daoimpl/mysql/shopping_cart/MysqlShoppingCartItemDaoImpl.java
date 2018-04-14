package core.daoimpl.mysql.shopping_cart;

import core.dao.catalog.product.ProductDao;
import core.dao.customer.CustomerDao;
import core.dao.shopping_cart.ShoppingCartItemDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.Product;
import core.dto.model.shoppingcart.ShoppingCartItem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlShoppingCartItemDaoImpl implements ShoppingCartItemDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

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

    public List<ShoppingCartItem> getByShoppingCartId(int shoppingCartId) {
        ProductDao productDao = daoFactory.getProductDao();
        List<ShoppingCartItem> list = new ArrayList<ShoppingCartItem>();
        String sql = "CALL PROC_SHOPPING_CART_DETAIL_SELECT_BY_SHOPPING_CART_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, shoppingCartId);
            rs = cs.executeQuery();
            while (rs.next()) {
                list.add(new ShoppingCartItem(productDao.getById(Integer.parseInt(rs.getString(2))),
                        rs.getString(3), Integer.parseInt(rs.getString(4))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ShoppingCartItemDao shoppingCartItemDao = daoFactory.getShoppingCartItemDao();

        List<ShoppingCartItem> lis = shoppingCartItemDao.getByShoppingCartId(-1105272073);
        for (ShoppingCartItem li : lis) {
            System.out.println(li.getProduct().getName());
        }
    }

}
