package by.bstu.unittesting.page;
import by.bstu.unittesting.model.Phone;
import by.bstu.unittesting.page.AbstractPage;
import by.bstu.unittesting.page.IncorrectOrderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CallPhonePage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";



    private static final By CALL_PHONE = By.xpath("//*[@id=\"recent_goods_scroller\"]/header/a[1]");
    private static final By SUBMIT_DATA = By.xpath("//*[@id=\"pages_recent_goods\"]/header/div[3]/ul/li[3]");
    private static final By ERROR_FIELD_LOCATION = By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/div[1]/div/div[1]/a");

    public CallPhonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CallPhonePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }


    public CallPhonePage callPhoneClick() {
        WebElement call = driver.findElement(CALL_PHONE);
        call.click();
        return this;
    }


    public CallPhonePage submitClick(){
        driver.findElement(SUBMIT_DATA).click();
        return this;
    }

    public String getErrorText() {
        return driver.findElement(ERROR_FIELD_LOCATION).getText();
    }

}