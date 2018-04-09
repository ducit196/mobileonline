package api.test;

import core.dao.catalog.product.AttributeDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.catalog.product.Attribute;
import org.junit.Test;

public class AttributeTest {

    @Test
    public void getByIdTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        AttributeDao attributeDao = daoFactory.getAttributeDao();
        Attribute byId = attributeDao.getById(1);
        System.out.println(byId.getName());
    }

}
