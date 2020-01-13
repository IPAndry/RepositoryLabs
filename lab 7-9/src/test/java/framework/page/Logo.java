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

public class Logo extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Logo.class);

    @FindBy(xpath = "//*[@class='auth-b-title']")
    private WebElement deliveryFieldLocator;

    public Logo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Logo openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public Logo notebookButton() {
        WebElement deliveryButton = driver.findElement(By.xpath("//*[@id='2416']"));
        deliveryButton.click();
        logger.info("Asus opend");
        return this;
    }

    public Logo logoButton() {
        WebElement openManDeliveryButton = driver.findElement(By.xpath("//*[@class='logo-link responsive-img logo-link-svg']"));
        openManDeliveryButton.click();
        logger.info("Main logo click");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='auth-b-title']")));

        return deliveryFieldLocator.getText();
    }
}
