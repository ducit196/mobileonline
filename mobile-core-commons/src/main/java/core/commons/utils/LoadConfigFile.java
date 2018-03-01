package core.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author DucBa
 */
public class LoadConfigFile {

    /**
     * @param src the path of config file
     * @return list of imformation config
     */
    public static List<String> loadConfigFile(String src) {
        List<String> configImformation = new ArrayList<String>();
        Properties properties = new Properties();
        InputStream in = LoadConfigFile.class.getResourceAsStream("../../db_config_mysql.properties");
        try {
            properties.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        configImformation.add(properties.getProperty("DRIVER"));
        configImformation.add(properties.getProperty("URL"));
        configImformation.add(properties.getProperty("USER"));
        configImformation.add(properties.getProperty("PASS"));
        return configImformation;
    }

}
