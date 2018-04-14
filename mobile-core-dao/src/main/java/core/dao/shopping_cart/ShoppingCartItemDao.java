package core.dao.shopping_cart;

import core.dto.model.shoppingcart.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemDao {

    void insert(ShoppingCartItem shoppingCartItem, int shoppingCartId);

    List<ShoppingCartItem> getByShoppingCartId(int shoppingCartId);
}
