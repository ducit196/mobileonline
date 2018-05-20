package core.dao.shopping_cart;

import core.dto.model.shoppingcart.ShoppingCart;

import java.util.Date;

public interface ShoppingCartDao {

    void insert(ShoppingCart shoppingCart, Date createOn, int customerId);

    ShoppingCart getByCustomerId(int customerId);

    void delete(int shoppingCartId);
}
