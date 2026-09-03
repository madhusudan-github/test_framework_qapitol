package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class WaitUtils {

        private WebDriverWait wait;

        // Constructor
        public WaitUtils(WebDriver driver) {

            wait = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(15)
            );
        }

        // Wait for element to be visible
        public WebElement waitForElement(By locator) {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );
        }

        // Wait for element to be clickable and click
        public void click(By locator) {

            wait.until(
                    ExpectedConditions.elementToBeClickable(locator)
            ).click();
        }

        // Wait for element and enter text
        public void enterText(By locator, String text) {

            WebElement element = waitForElement(locator);

            element.clear();
            element.sendKeys(text);
        }
    }

