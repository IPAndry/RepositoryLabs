package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagePage extends Page {

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private static final By CLOSE_ANNOYING = By.xpath("/html/body/header/div/div/div[1]/div[2]/div[2]/div[1]/div/a[1]");
    private static final By CHANGE_CITY = By.xpath("//*[@id=\"city-chooser\"]");
    private static final By INSERT_CITY = By.xpath("//*[@id=\"popup_suggest_locality\"]");
    private static final By ERROR_FIELD_LOCATION = By.xpath("/html/body/header/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/ul/li");


    public SendMessagePage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public SendMessagePage Annoying()
    {
        waitUntilElementToBeClickable(CLOSE_ANNOYING).click();
        return this;
    }

    public SendMessagePage ChangeCity() {
        waitUntilElementToBeClickable(CHANGE_CITY).click();
        return this;
    }

    public SendMessagePage InsertCity(String city) {
        driver.findElement(INSERT_CITY).sendKeys(city);
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }


}
