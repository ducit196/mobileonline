package api.test;

import core.dao.catalog.product.ManufacturerDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.catalog.product.Manufacturer;
import org.junit.Test;

public class ManufacturerTest {

    @Test
    public void getByIdTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ManufacturerDao manufacturerDao = daoFactory.getManufacturerDao();
        Manufacturer byId = manufacturerDao.getById(1);
        System.out.println(byId.getName());
    }
}
