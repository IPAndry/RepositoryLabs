package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Premium extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Premium.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/button")
    private WebElement errorFieldLocator;

    public Premium(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Premium openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public Premium GetPremiumButton() throws InterruptedException {
        WebElement statusButton = driver.findElement(By.xpath("/html/body/header/div/div/div[2]/ul/li[5]/a"));
        statusButton.click();
        logger.info("Clicked Premium button");
        Thread.sleep(5000);
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("/html/body/div[3]/div/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/button")));

        return errorFieldLocator.getText();
    }
}
