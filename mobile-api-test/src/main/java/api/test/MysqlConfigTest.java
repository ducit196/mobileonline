package api.test;

import core.daoimpl.factory.MysqlDAOFactory;
import org.junit.Test;

public class MysqlConfigTest {

    @Test
    public void testConfig() {
        MysqlDAOFactory mysqlDAOFactory = new MysqlDAOFactory();
        mysqlDAOFactory.createConnection();
    }

}
