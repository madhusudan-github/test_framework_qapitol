package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SearchPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Dynamic locator
    private By searchResults(String productName){
        return By.xpath("//span[@class='_Omnvo' and contains(.,'Showing') and contains(.,"+productName+") and contains(.,'results')]"
        );
    }

    // if results are displayed
    public boolean resultsAreDisplayed(String productName){
        return waitUtils.waitForElement(searchResults(productName)).isDisplayed();
    }
}
