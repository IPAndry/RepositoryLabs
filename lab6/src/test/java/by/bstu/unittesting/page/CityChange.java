package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityChange extends Page {

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private static final By CLOSE_ANNOYING = By.xpath("//*[@class=\"popup-close\"]");
    private static final By CHANGE_CITY = By.xpath("//*[@id='city-chooser']");
    private static final By INSERT_CITY = By.xpath("//*[@id='popup_suggest_locality']");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@class='suggestion-i not-found']");

    public CityChange(WebDriver driver) {
        super(driver);
    }

    public CityChange openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CityChange annoying()
    {
        waitUntilElementToBeClickable(CLOSE_ANNOYING).click();
        return this;
    }

    public CityChange changeCity() {
        waitUntilElementToBeClickable(CHANGE_CITY).click();
        return this;
    }

    public CityChange insertCity(String city) {
        driver.findElement(INSERT_CITY).sendKeys(city);
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }

}
