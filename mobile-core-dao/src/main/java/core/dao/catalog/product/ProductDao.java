package core.dao.catalog.product;

import core.dto.model.catalog.product.Product;

import java.util.List;

public interface ProductDao {
    Product getById(int id);

    List<Product> getByCategoryId(int categoryId);
}
