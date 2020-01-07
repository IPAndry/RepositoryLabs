package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CallPhonePahe extends Page {

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private static final By NOTEBOOK = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[2]/span[2]/a");
    private static final By ASUS = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[1]/input");
    private static final By ASUS_ROG = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/div[1]/div[1]/input");
    private static final By BUY_BUTTON = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[2]/div[1]/div[2]/div/span/button");
/*  private static final By IDINH = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[2]/span[2]/a");
    private static final By IDINH1 = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[2]/span[2]/ul/li[1]/a");
    private static final By TYPE_FIELD = By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/div[16]/div[1]/a");
    private static final By BUY = By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/div[16]/div[2]/div/form/label/img");
    private static final By BUY1 = By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/div[16]/div[2]/div/form/div[2]/span/a");*/
    private static final By ERROR_FIELD_LOCATION = By.xpath("/html/body/header/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[1]/div[1]/div[2]/div/p");

    public CallPhonePahe(WebDriver driver) {
        super(driver);
    }

    public CallPhonePahe openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CallPhonePahe Notebook() {
        waitUntilElementToBeClickable(NOTEBOOK).click();
        return this;
    }

    public CallPhonePahe Asus(String user){
        driver.findElement(ASUS).sendKeys(user);
        return this;
    }

    public CallPhonePahe AsusRog(String pass){
        driver.findElement(ASUS_ROG).sendKeys(pass);
        return this;
    }

    public CallPhonePahe BuyButton(){
        waitUntilElementToBeClickable(BUY_BUTTON).click();
        return this;
    }

/*
    public CallPhonePahe IdiNH(){
        waitUntilElementToBeClickable(IDINH).click();
        return this;
    }

    public CallPhonePahe IdiNH1(){
        waitUntilElementToBeClickable(IDINH1).click();
        return this;
    }

    public CallPhonePahe Type(){
        waitUntilElementToBeClickable(TYPE_FIELD).click();
        return this;
    }

    public CallPhonePahe Buy(){
        waitUntilElementToBeClickable(BUY).click();
        return this;
    }

    public CallPhonePahe Buy1(){
        waitUntilElementToBeClickable(BUY1).click();
        return this;
    }
*/

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }

}
