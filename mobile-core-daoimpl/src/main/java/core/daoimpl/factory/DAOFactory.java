package core.daoimpl.factory;

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

/**
 * @author DucBa
 */
public abstract class DAOFactory {
    public static final int ORACLE = 1;
    public static final int CLOUDSCAPE = 2;
    public static final int SQLSERVER = 3;
    public static final int MYSQL = 4;

    //select database
    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MysqlDAOFactory();
            default:
                return null;
        }
    }

    //list of defined dao
    public abstract CategoryDao getCategoryDao();
    public abstract AttributeDao getAttributeDao();
    public abstract AttributeValueDao getAttributeValueDao();
    public abstract ManufacturerDao getManufacturerDao();
    public abstract ProductDao getProductDao();
    public abstract ProductImageDao getProductImageDao();
    public abstract ProductReviewDao getProductReviewDao();
    public abstract AccountDao getAccountDao();
    public abstract AddressDao getAddressDao();
    public abstract RoleDao getRoleDao();
    public abstract CustomerDao getCustomerDao();
    public abstract EmployeeDao getEmployeeDao();
    public abstract CouponDao getCouponDao();
    public abstract OrderDao getOrderDao();
    public abstract ShippingDao getShippingDao();

}
