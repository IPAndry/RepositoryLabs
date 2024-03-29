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

public class Lang extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Lang.class);

    @FindBy(xpath = "//a[@data-lang='ua']")
    private WebElement paymentButton;

    @FindBy(xpath = "//h2[@class='auth-b-title']")
    private WebElement paymentFieldLocator;

    public Lang(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Lang openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Click to change language");
        return this;
    }

    public Lang ukrainianButton(){
        paymentButton.click();
        logger.info("Language changed");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"auth-block-main\"]/div/h2")));

        return paymentFieldLocator.getText();
    }
}
