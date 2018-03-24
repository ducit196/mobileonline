package api.test;

import core.dao.catalog.category.CategoryDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.catalog.category.Category;
import org.junit.Test;

import java.util.List;

public class CategoryDaoTest {

    @Test
    public void getAllParentCategoryTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CategoryDao categoryDao = daoFactory.getCategoryDao();
        List<Category> listParentCategory = categoryDao.getAllParentCategory();
        for (Category category : listParentCategory) {
            System.out.println(category.getCategoryName());
        }
    }

    @Test
    private void getByIdTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        CategoryDao categoryDao = daoFactory.getCategoryDao();
        Category byId = categoryDao.getById(2);
        System.out.println(byId.getCategoryName());
    }
}
