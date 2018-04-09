package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.AttributeValueDao;
import core.dao.catalog.product.ProductAttributeDao;
import core.daoimpl.factory.DAOFactory;
import core.daoimpl.factory.MysqlDAOFactory;
import core.dto.model.catalog.product.ProductAttribute;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlProductAttributeDaoImpl implements ProductAttributeDao {

    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    private static MysqlProductAttributeDaoImpl ourInstance = new MysqlProductAttributeDaoImpl();

    public static MysqlProductAttributeDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlProductAttributeDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }

    public ProductAttribute getById(int id) {
        return null;
    }

    public List<ProductAttribute> getByProductId(int productId) {
        AttributeValueDao attributeValueDao = daoFactory.getAttributeValueDao();
        List<ProductAttribute> list = new ArrayList<ProductAttribute>();
        String sql = "CALL PROC_PRODUCT_ATTRIBUTE_SELECT_BY_PRODUCT_ID(?)";
        try {
            cs = con.prepareCall(sql);
            cs.setInt(1, productId);
            rs = cs.executeQuery();
            while (rs.next()) {
                list.add(new ProductAttribute(Integer.parseInt(rs.getString(1)), null,
                        attributeValueDao.getById(Integer.parseInt(rs.getString(3))),
                        Integer.parseInt(rs.getString(4)), Float.parseFloat(rs.getString(5))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        ProductAttributeDao productAttributeDao = daoFactory.getProductAttributeDao();
        List<ProductAttribute> byProductId = productAttributeDao.getByProductId(1);
        for (ProductAttribute productAttribute : byProductId) {
            System.out.println(productAttribute.getAttribute().getName());
        }
    }
}
