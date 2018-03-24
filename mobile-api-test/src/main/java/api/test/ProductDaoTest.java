package api.test;

import core.dao.catalog.category.CategoryDao;
import core.dao.catalog.product.ProductDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.catalog.product.Product;
import org.junit.Test;

public class ProductDaoTest {

    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    @Test
    public void getByIdTest() {
        ProductDao productDao = daoFactory.getProductDao();
        Product byId = productDao.getById(2);
        System.out.println(byId.getName());
    }

}
