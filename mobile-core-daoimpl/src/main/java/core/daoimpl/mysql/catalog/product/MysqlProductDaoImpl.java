package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.ProductDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.category.Category;
import core.dto.model.catalog.product.Manufacturer;
import core.dto.model.catalog.product.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlProductDaoImpl implements ProductDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    private static MysqlProductDaoImpl ourInstance = new MysqlProductDaoImpl();

    public static MysqlProductDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlProductDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public Product getById(int id) {
        String sql = "CALL PROC_PRODUCT_SELECT_BY_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(Integer.parseInt(rs.getString(1)));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setThumbai(rs.getString(4));
                product.setPrice(Float.parseFloat(rs.getString(5)));
                product.setLength(Float.parseFloat(rs.getString(6)));
                product.setWidth(Float.parseFloat(rs.getString(7)));
                product.setHeight(Float.parseFloat(rs.getString(8)));
                Manufacturer manufacturer = daoFactory.getManufacturerDao().getById(Integer.parseInt(rs.getString(9)));
                product.setManufacturer(manufacturer);
                Category category = daoFactory.getCategoryDao().getById(Integer.parseInt(rs.getString(10)));
                product.setCategory(category);
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getByCategoryId(int categoryId) {
        List<Product> list = new ArrayList<Product>();
        String sql = "CALL PROC_PRODUCT_SELECT_BY_CATEGORY(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, categoryId);
            rs = cs.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(Integer.parseInt(rs.getString(1)));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setThumbai(rs.getString(4));
                product.setPrice(Float.parseFloat(rs.getString(5)));
                product.setLength(Float.parseFloat(rs.getString(6)));
                product.setWidth(Float.parseFloat(rs.getString(7)));
                product.setHeight(Float.parseFloat(rs.getString(8)));
                Manufacturer manufacturer = daoFactory.getManufacturerDao().getById(Integer.parseInt(rs.getString(9)));
                product.setManufacturer(manufacturer);
                Category category = daoFactory.getCategoryDao().getById(Integer.parseInt(rs.getString(10)));
                product.setCategory(category);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListRecommend(int productId) {
        List<Product> list = new ArrayList<Product>();
        String sql = "CALL PROC_PRODUCT_GET_RECOMMEND(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, productId);
            rs = cs.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(Integer.parseInt(rs.getString(1)));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setThumbai(rs.getString(4));
                product.setPrice(Float.parseFloat(rs.getString(5)));
                product.setLength(Float.parseFloat(rs.getString(6)));
                product.setWidth(Float.parseFloat(rs.getString(7)));
                product.setHeight(Float.parseFloat(rs.getString(8)));
                Manufacturer manufacturer = daoFactory.getManufacturerDao().getById(Integer.parseInt(rs.getString(9)));
                product.setManufacturer(manufacturer);
                Category category = daoFactory.getCategoryDao().getById(Integer.parseInt(rs.getString(10)));
                product.setCategory(category);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {
        MysqlProductDaoImpl instance = MysqlProductDaoImpl.getInstance();
        List<Product> byCategoryId = instance.getListRecommend(1);
        for (Product product : byCategoryId) {
            System.out.println(product.getName());
        }
    }
}
