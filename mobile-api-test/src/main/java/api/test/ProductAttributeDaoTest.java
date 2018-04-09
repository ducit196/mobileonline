package api.test;

import core.dao.catalog.product.ProductAttributeDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.catalog.product.ProductAttribute;
import org.junit.Test;

import java.util.List;

public class ProductAttributeDaoTest {

    @Test
    public void getByProductTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ProductAttributeDao productAttributeDao = daoFactory.getProductAttributeDao();
        List<ProductAttribute> byProductId = productAttributeDao.getByProductId(1);
        for (ProductAttribute productAttribute : byProductId) {
            System.out.println(productAttribute.getAttribute().getName());
        }
    }

}
