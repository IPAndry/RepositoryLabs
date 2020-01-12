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


public class FullInfo extends AbstractPage {

    private final Logger logger = LogManager.getLogger(FullInfo.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    private final By orderStatusButton = By.className("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]");

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[3]/div/div[5]/ul/li[2]/span/img")
    private WebElement errorFieldLocator;

    @FindBy(xpath = "//*[@id=\"edit-order-number\"]")
    private WebElement originInput;

    private final By searchButtonLocator = By.className("search_button");

    public FullInfo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public FullInfo openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public FullInfo NotebookButton() {
        WebElement statusButton = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/nav/div/ul/li[1]/a"));
        statusButton.click();
        logger.info("Clicked notebooks button and redirect on page notebooks");
        return this;
    }

    public FullInfo AsusButton(){
        WebElement button = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div/div[1]/div[1]/div/ul/li[1]/a"));
        button.click();
        logger.info("Clicked ASUS button and redirect on page ASUS");
        return this;
    }

    public FullInfo ListButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div/div[2]/div[2]/a"));
        button.click();
        logger.info("Clicked list button");
        Thread.sleep(5000);
        return this;
    }

    public String getErrorText() {
        WebElement test1 = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#catalog_goods_block > div > div:nth-child(3) > div.g-i-list-middle-part > div > div.goods-item-pic > ul > li:nth-child(2) > span > img")));
        return errorFieldLocator.getText();
    }
}
