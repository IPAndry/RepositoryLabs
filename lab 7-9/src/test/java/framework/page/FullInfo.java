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


public class FullInfo extends AbstractPage {

    private final Logger logger = LogManager.getLogger(FullInfo.class);

    @FindBy(xpath = "//*[@class='g-i-list-icons']")
    private WebElement errorFieldLocator;

    @FindBy(xpath = "//*[@id=\"edit-order-number\"]")
    private WebElement originInput;

    public FullInfo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public FullInfo openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public FullInfo notebookButton() {
        WebElement statusButton = driver.findElement(By.xpath("//*[@id='2416']"));
        statusButton.click();
        logger.info("Clicked notebooks button and redirect on page notebooks");
        return this;
    }

    public FullInfo asusButton(){
        WebElement button = driver.findElement(By.xpath("//*[@href='https://rozetka.com.ua/notebooks/c80004/filter/producer=asus/']"));
        button.click();
        logger.info("Clicked ASUS button and redirect on page ASUS");
        return this;
    }

    public FullInfo listButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//*[@id='filter_viewlist']"));
        button.click();
        logger.info("Clicked list button");
        Thread.sleep(5000);
        return this;
    }

    public String getErrorText() {
        WebElement test1 = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='g-i-list-icons']")));
        return errorFieldLocator.getText();
    }
}
