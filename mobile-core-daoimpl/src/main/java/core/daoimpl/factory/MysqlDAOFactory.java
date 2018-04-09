package core.daoimpl.factory;

import core.commons.utils.LoadConfigFile;
import core.dao.catalog.category.CategoryDao;
import core.dao.catalog.product.*;
import core.dao.common.AccountDao;
import core.dao.common.AddressDao;
import core.dao.common.RoleDao;
import core.dao.customer.CustomerDao;
import core.dao.employee.EmployeeDao;
import core.dao.order.CouponDao;
import core.dao.order.OrderDao;
import core.dao.shipping.ShippingDao;
import core.dao.shopping_cart.ShoppingCartDao;
import core.dao.shopping_cart.ShoppingCartItemDao;
import core.daoimpl.mysql.catalog.category.MysqlCategoryDaoImpl;
import core.daoimpl.mysql.catalog.product.*;
import core.daoimpl.mysql.common.MysqlAccountDaoImpl;
import core.daoimpl.mysql.common.MysqlAddressDaoImpl;
import core.daoimpl.mysql.common.MysqlRoleDaoImpl;
import core.daoimpl.mysql.customer.MysqlCustomerDaoImpl;
import core.daoimpl.mysql.employee.MysqlEmployeeDaoImpl;
import core.daoimpl.mysql.order.MysqlCouponDaoImpl;
import core.daoimpl.mysql.order.MysqlOrderDaoImpl;
import core.daoimpl.mysql.shipping.MysqlShippingDaoImpl;
import core.daoimpl.mysql.shopping_cart.MysqlShoppingCartDaoImpl;
import core.daoimpl.mysql.shopping_cart.MysqlShoppingCartItemDaoImpl;
import core.dto.model.catalog.product.ProductReview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAOFactory extends DAOFactory {

    public static final String PATH_FILE = "../../../db_config_mysql.properties";
    public static final String DRIVER = LoadConfigFile.loadConfigFile(PATH_FILE).get(0);
    public static final String DBURL = LoadConfigFile.loadConfigFile(PATH_FILE).get(1);
    public static final String USER = LoadConfigFile.loadConfigFile(PATH_FILE).get(2);
    public static final String PASS = LoadConfigFile.loadConfigFile(PATH_FILE).get(3);

    public static Connection createConnection() {
        try {

            Class.forName(DRIVER);
            return DriverManager.getConnection(DBURL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CategoryDao getCategoryDao() {
        return MysqlCategoryDaoImpl.getInstance();
    }

    public AttributeDao getAttributeDao() {
        return MysqlAttributeDaoImpl.getInstance();
    }

    public AttributeValueDao getAttributeValueDao() {
        return MysqlAttributeValueDaoImpl.getInstance();
    }

    public ProductAttributeDao getProductAttributeDao() {
        return MysqlProductAttributeDaoImpl.getInstance();
    }

    public ManufacturerDao getManufacturerDao() {
        return MysqlManufacturerDaoImpl.getInstance();
    }

    public ProductDao getProductDao() {
        return MysqlProductDaoImpl.getInstance();
    }

    public ProductReviewDao getProductReviewDao() {
        return MysqlProductReviewDaoImpl.getInstance();
    }

    public AccountDao getAccountDao() {
        return MysqlAccountDaoImpl.getInstance();
    }

    public AddressDao getAddressDao() {
        return MysqlAddressDaoImpl.getInstance();
    }

    public RoleDao getRoleDao() {
        return MysqlRoleDaoImpl.getInstance();
    }

    public CustomerDao getCustomerDao() {
        return MysqlCustomerDaoImpl.getInstance();
    }

    public EmployeeDao getEmployeeDao() {
        return MysqlEmployeeDaoImpl.getInstance();
    }

    public CouponDao getCouponDao() {
        return MysqlCouponDaoImpl.getInstance();
    }

    public OrderDao getOrderDao() {
        return MysqlOrderDaoImpl.getInstance();
    }

    public ShippingDao getShippingDao() {
        return MysqlShippingDaoImpl.getInstance();
    }

    public ShoppingCartDao getShoppingCartDao() {
        return MysqlShoppingCartDaoImpl.getInstance();
    }

    public ShoppingCartItemDao getShoppingCartItemDao() {
        return MysqlShoppingCartItemDaoImpl.getInstance();
    }

}
