package by.bstu.unittesting.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NotebookFind extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Premium.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";



    private static final By NOTEBOOK_FINDER = By.xpath("//*[@id=\"2416\"]/a");
    private static final By ASUS_FINDER = By.xpath("//*[@id=\"content-inner-block\"]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div/div[1]/div[1]/div/ul/li[1]/a");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[1]/div[1]/div/div/div/div[3]/a");

    public NotebookFind(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NotebookFind openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }


    public NotebookFind NotebookButton() {
        WebElement call = driver.findElement(NOTEBOOK_FINDER);
        call.click();
        return this;
    }


    public NotebookFind AsusButton(){
        driver.findElement(ASUS_FINDER).click();
        return this;
    }

    public String getErrorText() {
        return driver.findElement(ERROR_FIELD_LOCATION).getText();
    }

}