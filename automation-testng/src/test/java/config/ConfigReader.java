package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try {
            InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("testdata.properties");
            if (in == null) {
                throw new RuntimeException("testdata.properties not found");
            }
            props.load(in);
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load testdata.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
