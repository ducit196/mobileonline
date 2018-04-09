package core.dto.model.catalog.product;

/**
 * @author DucBa
 */
public class ProductAttribute {
    private int id;
    private Product product;
    private AttributeValue attribute;
    private int amount;
    private float additionalPrice;

    public ProductAttribute() {
    }

    public ProductAttribute(int id, Product product, AttributeValue attribute, int amount, float additionalPrice) {
        this.id = id;
        this.product = product;
        this.attribute = attribute;
        this.amount = amount;
        this.additionalPrice = additionalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
