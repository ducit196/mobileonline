package core.dto.model.catalog.product;

import core.dto.model.catalog.category.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DucBa
 */
public class Product {
    private long id;
    private String name;
    private String description;
    private List<ProductImage> images = new ArrayList<ProductImage>();
    private Category category;
    private Manufacturer manufacturer;
    private float price;
    private float length;
    private float width;
    private float height;
    private float weight;
    private float ram;
    private float rom;

    public Product() {
    }

    public Product(long id, String name, String description, List<ProductImage> images,
                   Category category, Manufacturer manufacturer, float price,
                   float length, float width, float height, float weight,
                   float ram, float rom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.category = category;
        this.manufacturer = manufacturer;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.ram = ram;
        this.rom = rom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getRam() {
        return ram;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public float getRom() {
        return rom;
    }

    public void setRom(float rom) {
        this.rom = rom;
    }
}
