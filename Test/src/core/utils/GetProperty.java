package core.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {

    public static String getConfProperties(String propertyConf) throws IOException {

        String property = null;
        Properties prop = new Properties();

        prop.loadFromXML(new FileInputStream(System.getProperty("user.dir")+"/config.xml"));
        property = prop.getProperty(propertyConf);

        return property;
    }
}