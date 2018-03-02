package core.dto.model.catalog.product;

/**
 * @author DucBa
 */
public class ProductAttribute {
    private Product product;
    private AttributeValue attribute;
    private int amount;
    private float additionalPrice;

    public ProductAttribute() {
    }

    public ProductAttribute(Product product, AttributeValue attribute, int amount, float additionalPrice) {
        this.product = product;
        this.attribute = attribute;
        this.amount = amount;
        this.additionalPrice = additionalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AttributeValue getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeValue attribute) {
        this.attribute = attribute;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(float additionalPrice) {
        this.additionalPrice = additionalPrice;
    }
}
