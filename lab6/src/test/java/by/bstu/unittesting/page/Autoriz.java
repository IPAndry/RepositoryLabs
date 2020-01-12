package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Autoriz extends Page {

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private static final By NOTEBOOK = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[2]/span[2]/a");
    private static final By ASUS = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[1]/input");
    private static final By ASUS_ROG = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/div[1]/div[1]/input");
    private static final By BUY_BUTTON = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/div[1]/div[2]/div/span/button");
    private static final By ERROR_FIELD_LOCATION = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[1]/div[2]/div/p");

    public Autoriz(WebDriver driver) {
        super(driver);
    }

    public Autoriz openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public Autoriz Click() {
        waitUntilElementToBeClickable(NOTEBOOK).click();
        return this;
    }

    public Autoriz Mail(String user){
        driver.findElement(ASUS).sendKeys(user);
        return this;
    }

    public Autoriz Pass(String pass){
        driver.findElement(ASUS_ROG).sendKeys(pass);
        return this;
    }

    public Autoriz BuyButton(){
        waitUntilElementToBeClickable(BUY_BUTTON).click();
        return this;
    }


    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }

}
