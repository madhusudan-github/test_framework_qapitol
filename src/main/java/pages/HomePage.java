package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver ;
    private WaitUtils waitUtils;

    private By loginPopupButtonClose = By.xpath("//span[@role='button' and @class='b3wTlE']");
    private By searchBox = By.xpath("//div[@class='Afujtw']//input[@name='q']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void closeLoginPopupButtonClose(){
        waitUtils.click(loginPopupButtonClose);
    }

    public void searchBox(String productName){
        waitUtils.enterText(searchBox,productName);
        driver.findElement(searchBox).submit();
    }



}
