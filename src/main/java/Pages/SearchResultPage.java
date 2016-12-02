package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Serg on 01.12.2016.
 */
public class SearchResultPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public  SearchResultPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);
    }
    public void waitForSearchResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    public void openBookFromResultsBy(String bookTitle){
        //webDriver.findElement(By.linkText(bookTitle));
        List<WebElement> books = webDriver.findElement(By.className("top"))
                                          .findElements(By.tagName("tr"));
        for (WebElement book: books){
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getText().contains(bookTitle))
                bookLink.click();
        }

    }
}
