package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Credit extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Credit.class);

    @FindBy(xpath = "//a[@class = 'whitelink' and text()=' Кредит ']")
    private WebElement salesButton;

    @FindBy(xpath = "//h1[text()='Покупка в кредит']")
    private WebElement salesFieldLocator;

    public Credit(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Credit openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Open Credit");
        return this;
    }

    public Credit getCreditButton(){
        salesButton.click();
        logger.info("Credit was opened");
        return this;
    }


    public String getErrorText() {
        return salesFieldLocator.getText();
    }

}
