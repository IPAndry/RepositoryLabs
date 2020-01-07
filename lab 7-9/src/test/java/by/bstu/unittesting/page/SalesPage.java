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

import java.util.List;

public class SalesPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "//*[@id=\"body-header\"]/div/div/div[1]/div[2]/ul/li[2]/a")
    private WebElement salesButton;

    @FindBy(xpath = "//*[@id=\"content-inner-block\"]/div[2]/div/div/div[2]/div[1]/h1")
    private WebElement salesFieldLocator;


    public SalesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SalesPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Open Credit");
        return this;
    }

    public SalesPage openSales(){
        salesButton.click();
        logger.info("Credit was opened");
        return this;
    }


    public String getErrorText() {
        return salesFieldLocator.getText();
    }

}
