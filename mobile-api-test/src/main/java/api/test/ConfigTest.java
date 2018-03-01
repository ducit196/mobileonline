package api.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ConfigTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream in = ConfigTest.class.getResourceAsStream("../../db_config_mysql.properties");
        properties.load(new InputStreamReader(in, "UTF-8"));
        System.out.println(properties.getProperty("USER"));
    }

}
