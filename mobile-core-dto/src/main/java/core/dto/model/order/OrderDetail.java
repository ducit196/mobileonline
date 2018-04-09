package core.dto.model.order;

import core.dto.model.catalog.product.Attribute;
import core.dto.model.catalog.product.Product;

public class OrderDetail {

    private Product product;
    private String attribute;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Product product, String attribute, int quantity) {
        this.product = product;
        this.attribute = attribute;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
