package core.dto.model.catalog.product;

/**
 * @author DucBa
 */
public class AttributeValue {
    private int id;
    private String name;
    private Attribute attribute;

    public AttributeValue() {
    }

    public AttributeValue(int id, String name, Attribute attribute) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
