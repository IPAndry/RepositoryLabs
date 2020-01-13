package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Autoriz extends Page {

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private static final By LOGIN = By.xpath("//*[@id='header_user_menu_parent']");
    private static final By EMAIL = By.xpath("//input[@class='input-text auth-input-text' and @name='login']");
    private static final By PASSWORD = By.xpath("//*[@type='password' and not(@tabindex='2')]");
    private static final By LOGIN_ACCOUNT = By.xpath("//*[@type='submit' and @name='auth_submit']");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@class='auth-title h2']");

    public Autoriz(WebDriver driver) {
        super(driver);
    }

    public Autoriz openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public Autoriz login_Button() {
        waitUntilElementToBeClickable(LOGIN).click();
        return this;
    }

    public Autoriz mail(String user){
        driver.findElement(EMAIL).sendKeys(user);
        return this;
    }

    public Autoriz pass(String pass){
        driver.findElement(PASSWORD).sendKeys(pass);
        return this;
    }

    public Autoriz loginAccount(){
        waitUntilElementToBeClickable(LOGIN_ACCOUNT).click();
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }

}
