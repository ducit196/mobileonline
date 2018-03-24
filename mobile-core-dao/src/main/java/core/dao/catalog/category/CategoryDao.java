package core.dao.catalog.category;

import core.dto.model.catalog.category.Category;

import java.util.List;

public interface CategoryDao {
    void add(Category category);

    List<Category> getAllParentCategory();

    List<Category> getAllChildrenByParentCategpry(int parentId);

    Category getById(int id);
}
