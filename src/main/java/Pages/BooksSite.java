package Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Serg on 01.12.2016.
 */
public class BooksSite {
    WebDriver webDriver;

    public BooksSite(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    public SearchResultPage searchResultPage() {
        return new SearchResultPage(webDriver);

    }

    public BookInfoPage bookInfoPage() {
        return new BookInfoPage();
    }
}