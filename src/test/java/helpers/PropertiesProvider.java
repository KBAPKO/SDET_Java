package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {

    static private Properties property;

    public static String getProperty(final String key) {
        if (property == null) {
            initData();
        }
        return property.getProperty(key);
    }

    private static void initData() {
        property = new Properties();
        FileInputStream data;
        try {
            data = new FileInputStream("src/test/resources/config.properties");
            property.load(data);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}
