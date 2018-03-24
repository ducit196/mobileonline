package core.daoimpl.mysql.catalog.category;

import core.dao.catalog.category.CategoryDao;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.category.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlCategoryDaoImpl implements CategoryDao {

    Connection con = null;
    java.sql.CallableStatement cs = null;
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

    public List<Category> getAllParentCategory() {
        List<Category> list = new ArrayList<Category>();
        String sql = "CALL PROC_CATEGORY_SELECT_ALL_PARENT_CATEGORY";
        try {
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(Integer.parseInt(rs.getString(1)));
                category.setCategoryName(rs.getString(2));
                category.setParentCategory(Integer.parseInt(rs.getString(3)));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Category> getAllChildrenByParentCategpry(int parentId) {
        List<Category> list = new ArrayList<Category>();
        String sql = "CALL PROC_CATEGORY_SELECT_ALL_CHILDREN_BY_PARENT(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, parentId);
            rs = cs.executeQuery();
            while (rs.next()) {
                list.add(new Category(Integer.parseInt(rs.getString(1)), rs.getString(2),
                        Integer.parseInt(rs.getString(3))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Category getById(int id) {
        String sql = "CALL PROC_CATEGORY_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(Integer.parseInt(rs.getString(1)));
                category.setCategoryName(rs.getString(2));
                category.setParentCategory(Integer.parseInt(rs.getString(3)));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MysqlCategoryDaoImpl instance = MysqlCategoryDaoImpl.getInstance();
        Category byId = instance.getById(2);
        System.out.println(byId.getCategoryName());
    }

}
