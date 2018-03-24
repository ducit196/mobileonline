package api.test;

import core.dao.common.RoleDao;
import core.daoimpl.factory.DAOFactory;
import core.dto.model.common.Role;
import org.junit.Test;

public class RoleDaoTest {

    @Test
    public void getByIdTest() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        RoleDao roleDao = daoFactory.getRoleDao();
        Role role = roleDao.getById(1);
        System.out.println(role.getDescription());
    }

}
