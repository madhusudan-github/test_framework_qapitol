package ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;


public class FlipkartLaunchTests extends BaseTest {

    @Test
    public void testFlipkartLaunch(){
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("title is :" + title);
        Assert.assertTrue(title
                .contains("Online Shopping Site"), "Flipkart was not launched successfully");
        Assert.assertTrue(url.toLowerCase().contains("flipkart.com"));
    }

    @Test
    public void verifyProductSearch(){
        HomePage homePage = new HomePage(driver);
        homePage.closeLoginPopupButtonClose();
        homePage.searchBox("iphone");
    }

    @Test
    public void verifyProductIsDisplayed(){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.closeLoginPopupButtonClose();
        homePage.searchBox("iphone");

       Assert.assertTrue(searchPage.resultsAreDisplayed("iphone"), "Search results are not displayed");
    }
}
