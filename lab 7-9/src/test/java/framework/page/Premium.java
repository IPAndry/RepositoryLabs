package framework.page;

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

    @FindBy(xpath = "//button[@name='sub-buy-one-click']")
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

    public Premium getPremiumButton() throws InterruptedException {
        WebElement statusButton = driver.findElement(By.xpath("//*[@href='https://rozetka.com.ua/premium/' and @class='hub-i-link sprite-side whitelink']   "));
        statusButton.click();
        logger.info("Clicked Premium button");
        Thread.sleep(5000);
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//button[@name='sub-buy-one-click']")));

        return errorFieldLocator.getText();
    }
}
