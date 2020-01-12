package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bonus extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Bonus.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "//*[@id=\"program-loyalty-header_btn\"]")
    private WebElement installmentButton;

    @FindBy(xpath = "//*[@id=\"program-loyalty-popup\"]/div/h3")
    private WebElement smartPhoneFieldLocator;


    public Bonus(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Bonus OpBonus() {
        driver.navigate().to(PAGE_URL);
        logger.info("Bonus open");
        return this;
    }

    public Bonus OpenBonus(){
        installmentButton.click();
        logger.info("Bonus opened");
        return this;
    }


    public String getErrorText() {
        return smartPhoneFieldLocator.getText();
    }

}
