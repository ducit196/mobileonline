package core.dao.catalog.product;

import core.dto.model.catalog.product.ProductAttribute;

import java.util.List;

public interface ProductAttributeDao {

    ProductAttribute getById(int id);

    List<ProductAttribute> getByProductId(int productId);

}
