package core.daoimpl.mysql.catalog.product;

import core.dao.catalog.product.ProductReviewDao;
import core.daoimpl.factory.MysqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlProductReviewDaoImpl implements ProductReviewDao {

    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    private static MysqlProductReviewDaoImpl ourInstance = new MysqlProductReviewDaoImpl();

    public static MysqlProductReviewDaoImpl getInstance() {
        return ourInstance;
    }

    private MysqlProductReviewDaoImpl() {
        con = MysqlDAOFactory.createConnection();
    }
}
