package core.dao.shopping_cart;

import core.dto.model.shoppingcart.ShoppingCartItem;

public interface ShoppingCartItemDao {

    void insert(ShoppingCartItem shoppingCartItem, int shoppingCartId);

}
