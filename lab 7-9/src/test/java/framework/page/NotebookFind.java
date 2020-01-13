package framework.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NotebookFind extends AbstractPage {

    private final Logger logger = LogManager.getLogger(NotebookFind.class);

    private static final By NOTEBOOK_FINDER = By.xpath("//*[@id='2416']");
    private static final By ASUS_FINDER = By.xpath("//*[@href='https://rozetka.com.ua/notebooks/c80004/filter/producer=asus/']");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@href='https://rozetka.com.ua/asus_90nr01l3_m02530/p103698606/' and @class='responsive-img centering-child-img'] ");

    public NotebookFind(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NotebookFind openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }


    public NotebookFind notebookButton() {
        WebElement call = driver.findElement(NOTEBOOK_FINDER);
        call.click();
        logger.info("ASUS page opened");
        return this;
    }


    public NotebookFind asusButton(){
        driver.findElement(ASUS_FINDER).click();
        logger.info("Notebook page opened");
        return this;
    }

    public String getErrorText() {
        return driver.findElement(ERROR_FIELD_LOCATION).getText();
    }

}