package core.dto.model.catalog.category;

/**
 * @author DucBa
 */
public class Category {
    private int id;
    private String categoryName;
    private int parentCategory;

    public Category() {
    }

    public Category(int id, String categoryName, int parentCategory) {
        this.id = id;
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(int parentCategory) {
        this.parentCategory = parentCategory;
    }
}
