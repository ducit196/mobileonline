package core.dto.model.shoppingcart;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DucBa
 */
public class ShoppingCart {
    private int id;
    private HashMap<Integer, ShoppingCartItem> shoppingCart;

    public ShoppingCart() {
        shoppingCart = new HashMap<Integer, ShoppingCartItem>();
    }

    public ShoppingCart(int id, HashMap<Integer, ShoppingCartItem> shoppingCart) {
        this.id = id;
        this.shoppingCart = shoppingCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<Integer, ShoppingCartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * @param productId the product that you want to add to cart
     * @param item      the product and quantity those you want to add to cart
     */
    public void addToCart(int productId, ShoppingCartItem item) {
        //Have shoppingCart ever contains this product
        boolean check = shoppingCart.containsKey(productId);
        if (check) {
            //get old quantity
            int oldQuantity = shoppingCart.get(productId).getQuantity();
            //increase quantity
            int newQuantity = oldQuantity + item.getQuantity();
            item.setQuantity(newQuantity);
            shoppingCart.put(productId, item);
        } else {
            shoppingCart.put(productId, item);
        }
    }

    /**
     * remove the product out of shopping cart
     *
     * @param productId the id of the product you want to remove
     */
    public void removeCart(long productId) {
        if (shoppingCart.containsKey(productId)) {
            shoppingCart.remove(productId);
        }
    }

    /**
     * @return number of item
     */
    public int countItem() {
        return shoppingCart.size();
    }

    public float total() {
        float total = 0;
        for (Map.Entry<Integer, ShoppingCartItem> set : this.getShoppingCart().entrySet()) {
            total += set.getValue().getProduct().getPrice() * set.getValue().getQuantity();
        }
        return total;
    }
}
