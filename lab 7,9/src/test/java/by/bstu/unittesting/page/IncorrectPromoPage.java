package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Order;
import by.bstu.unittesting.model.Promocode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncorrectPromoPage extends AbstractPage{

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div[1]")
    private WebElement errorFieldLocator;

    public IncorrectPromoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public IncorrectPromoPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public IncorrectPromoPage selectOrderStatusButton() {
        WebElement statusButton = driver.findElement(By.xpath("/html/body/header/div/div/div[1]/div[2]/ul/li[7]/a"));
        statusButton.click();
        logger.info("Clicked Premium button");
        return this;
    }

    public IncorrectPromoPage selectOrderStatusButton1() {
        WebElement statusButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div/div/div/span/a"));
        statusButton.click();
        logger.info("Clicked Premium button");
        return this;
    }

    public IncorrectPromoPage selectOrderStatusButton2() throws InterruptedException {
        WebElement statusButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div/form/div[6]/div/div/span/button"));
        statusButton.click();
        logger.info("Clicked Premium button");
        Thread.sleep(5000);
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("/html/body/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div[1]")));

        return errorFieldLocator.getText();
    }


}
