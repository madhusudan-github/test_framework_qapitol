package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    // Config reader will read the
    // browser
    // environment
    // headless
    // base url

    //ConfigReader is a utility class responsible for reading framework configuration from properties files.
    //It loads the common configuration when the class is initialized and provides a generic get() method to retrieve configuration values.
    // It also supports environment-specific configuration by reading the environment from config.properties and dynamically loading the corresponding environment properties file,
    // such as qa.properties or prod.properties. This helps us avoid hardcoding environment-specific values in the automation code."

    private static Properties properties;

    static {
        loadConfig();
    }

    private static void loadConfig() {

        properties = new Properties();

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties not found in resources");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties", e);
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);
    }

    public static String getBaseUrl() {

        String environment = properties.getProperty("environment");

        Properties environmentProperties = new Properties();

        String fileName = environment + ".properties";

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException(
                        fileName + " not found in resources");
            }

            environmentProperties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load " + fileName, e);
        }

        return environmentProperties.getProperty("baseUrl");
    }
}
