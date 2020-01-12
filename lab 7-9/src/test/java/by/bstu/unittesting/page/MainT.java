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

public class MainT extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Premium.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "//*[@id=\"auth-block-main\"]/div/h2")
    private WebElement deliveryFieldLocator;

    public MainT(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainT openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public MainT NotebookButton() {
        WebElement deliveryButton = driver.findElement(By.xpath("//*[@id=\"2416\"]/a"));
        deliveryButton.click();
        logger.info("Asus opend");
        return this;
    }

    public MainT LogoButton() {
        WebElement openManDeliveryButton = driver.findElement(By.xpath("//*[@id=\"body-header\"]/div/div/div[2]/div[1]/a"));
        openManDeliveryButton.click();
        logger.info("Main logo click");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"auth-block-main\"]/div/h2")));

        return deliveryFieldLocator.getText();
    }

}
