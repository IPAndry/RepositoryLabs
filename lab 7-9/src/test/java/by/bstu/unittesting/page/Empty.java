package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Empty extends AbstractPage {

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private final Logger logger = LogManager.getLogger(Empty.class);

    private static final By SEND_MESSAGE = By.xpath("//*[@id=\"comparison\"]/a");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@id=\"comparison-popup\"]/div/h3");

    public Empty(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Empty openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened, open sravnenie");
        return this;
    }

    public Empty CompareButton() {
        driver.findElement(SEND_MESSAGE).click();
        logger.info("Sravnenie empty");
        return this;
    }


    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(ERROR_FIELD_LOCATION));

        return driver.findElement(ERROR_FIELD_LOCATION).getText();
    }
}
