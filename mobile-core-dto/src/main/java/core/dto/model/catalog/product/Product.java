package core.dto.model.catalog.product;

import core.dto.model.catalog.category.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DucBa
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private String thumbai;
    private float price;
    private float length;
    private float width;
    private float height;
    private Manufacturer manufacturer;
    private Category category;
    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, String description, String thumbai,
                   float price, float length, float width, float height,
                   Manufacturer manufacturer, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbai = thumbai;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
        this.manufacturer = manufacturer;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbai() {
        return thumbai;
    }

    public void setThumbai(String thumbai) {
        this.thumbai = thumbai;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
