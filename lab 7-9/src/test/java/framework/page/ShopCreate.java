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

public class ShopCreate extends AbstractPage{

    private final Logger logger = LogManager.getLogger(ShopCreate.class);

    @FindBy(xpath = "//*[@class=\"rz-detail-main-col-form-title\" and text() = 'Данные о магазине']")
    private WebElement errorFieldLocator;

    public ShopCreate(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ShopCreate openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public ShopCreate createShopButton() {
        WebElement statusButton = driver.findElement(By.xpath("//a[text()=' Продавать на Розетке ' and @class='whitelink']"));
        statusButton.click();
        logger.info("Click Sale button");
        return this;
    }

    public ShopCreate fullFormButton() {
        WebElement statusButton = driver.findElement(By.xpath("//a[text()='Заполнить заявку']"));
        statusButton.click();
        logger.info("Clicked zayvka button");
        return this;
    }

    public ShopCreate selectCheckbox() throws InterruptedException {
        WebElement statusButton = driver.findElement(By.xpath("//*[@id=\"newsellerSubmitButton\"]"));
        statusButton.click();
        logger.info("Clicked Submit button");
        Thread.sleep(5000);
        return this;
    }

    public String geterrortext() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//*[@class=\"rz-detail-main-col-form-title\" and text() = 'Данные о магазине']")));

        return errorFieldLocator.getText();
    }

}
