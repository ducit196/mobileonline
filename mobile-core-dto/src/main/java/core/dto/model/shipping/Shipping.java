package core.dto.model.shipping;

import core.dto.model.common.Address;

/**
 * @author DucBa
 */
public class Shipping {
    private int id;
    private String shippingType;
    private float shippingCost;
    private Address shippingAddress;

    public Shipping() {
    }

    public Shipping(int id, String shippingType, float shippingCost, Address shippingAddress) {
        this.id = id;
        this.shippingType = shippingType;
        this.shippingCost = shippingCost;
        this.shippingAddress = shippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
