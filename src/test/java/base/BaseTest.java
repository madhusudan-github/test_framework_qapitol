package base;

import config.ConfigReader;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.out.println("=== SETUP STARTED ===");

        DriverFactory.initDriver();

        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getBaseUrl());

        System.out.println("=== SETUP COMPLETED ===");
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}