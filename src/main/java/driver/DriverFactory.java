package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    //This DriverFactory is responsible for
    // creating, storing, accessing, and closing the Selenium WebDriver.
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        ChromeOptions options = new ChromeOptions();

        String headless = ConfigReader.get("headless");

        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--start-maximized");

        driver.set(new ChromeDriver(options));
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}
