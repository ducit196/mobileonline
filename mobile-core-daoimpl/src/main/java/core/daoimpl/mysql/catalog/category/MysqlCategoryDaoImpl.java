package core.daoimpl.mysql.catalog.category;

import core.dao.catalog.category.CategoryDao;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.category.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlCategoryDaoImpl implements CategoryDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlCategoryDaoImpl ourInstance = new MysqlCategoryDaoImpl();

    public static MysqlCategoryDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlCategoryDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public void add(Category category) {

    }
}
