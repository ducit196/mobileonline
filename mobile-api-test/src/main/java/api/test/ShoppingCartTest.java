package api.test;

import core.dao.catalog.product.ProductDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.catalog.product.Product;
import core.dto.model.shoppingcart.ShoppingCart;
import core.dto.model.shoppingcart.ShoppingCartItem;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void addToCartTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ProductDao productDao = daoFactory.getProductDao();

//        Product byId = productDao.getById(1);
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.addToCart(byId.getId(), new ShoppingCartItem(byId, 1));
//
//        int i = shoppingCart.countItem();
//        System.out.println(i);
    }


}
