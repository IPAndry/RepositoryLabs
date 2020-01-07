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

public class InstallmentPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(InstallmentPage.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "//*[@id=\"program-loyalty-header_btn\"]")
    private WebElement installmentButton;

    @FindBy(xpath = "//*[@id=\"program-loyalty-popup\"]/div/h3")
    private WebElement smartPhoneFieldLocator;


    public InstallmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public InstallmentPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Bonus open");
        return this;
    }

    public InstallmentPage openInstallment(){
        installmentButton.click();
        logger.info("Bonus opened");
        return this;
    }


    public String getErrorText() {
        return smartPhoneFieldLocator.getText();
    }

}
