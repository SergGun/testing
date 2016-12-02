import Pages.BooksSite;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Serg on 26.11.2016.
 */
public class ItBooksTests {
    WebDriver webDriver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);
    //MainPage mainPage;
    BooksSite website;


    @BeforeTest
    public void setUp(){
        website = new BooksSite(webDriver);
        webDriver.get("http://it-ebooks.info/");
        website.mainPage().switchSearchToTitle();
        website.mainPage().enterSearcheableText("Automation");
        website.mainPage().clickSearchButton();
        website.searchResultPage().waitForSearchResults();
    }
    @AfterTest
    public void tearDown(){
        if (webDriver != null)
            webDriver.quit();
    }

    @Test
    public void testBookSerch(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
        Assert.assertTrue(webDriver.findElement(By.className("top"))
                                   .findElement(By.tagName("table"))
                                   .findElements(By.tagName("tr"))
                                   .size() ==10);
    }

    @Test
    public void testOpenBookInfoFromSearch(){
        website.searchResultPage().openBookFromResultsBy("Home Automation with Intel");
    }

    @Test
    public void testSearchUrl(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search/?q=Automation&type=title"));
    }

}
