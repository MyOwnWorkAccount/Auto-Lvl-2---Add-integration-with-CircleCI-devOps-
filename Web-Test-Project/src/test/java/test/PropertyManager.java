package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

class PropertyManager {
    private final static String propsFilePath = "./src/test/resources/config.properties";
    private static Properties properties = getProperties();

    public final static String browser = properties.getProperty("browser");
    public final static String url = properties.getProperty("url");

    private static Properties getProperties() {
        Properties props = new Properties();
        try {
            InputStream fileStream = new FileInputStream(propsFilePath);
            props.load(fileStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
}
