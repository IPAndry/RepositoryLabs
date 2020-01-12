package by.bstu.unittesting.page;

import by.bstu.unittesting.model.LoginModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends AbstractPage {

    private final Logger logger = LogManager.getLogger(Premium.class);

    private static final String PAGE_URL = "https://rozetka.com.ua/";

    @FindBy(xpath = "//*[@id=\"popup_signin\"]/div[1]/div[1]/input")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"popup_signin\"]/div[1]/div[2]/div[1]/div[1]/input")
    private WebElement search1;

    //*[@id="header_user_menu_parent"]/a

    @FindBy(xpath = "//*[@id=\"popup_signin\"]/div[1]/div[1]/input")
    private WebElement itemFieldLocator;


    public Login(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Login openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public Login LoginButton() {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"header_user_menu_parent\"]/a"));
        search.click();
        logger.info("Click Login");
        return this;
    }

    public Login EmailField(LoginModel item) {
        search.sendKeys(item.getSearch());
        logger.info("Email input");
        return this;
    }

    public Login PasswordField(LoginModel item) {
        search1.sendKeys(item.getSearch());
        logger.info("Password input");
        return this;
    }

    public Login EnterAccountButton() {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"popup_signin\"]/div[1]/div[2]/div[1]/div[2]/div/span/button"));
        search.click();
        logger.info("Login button");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup_signin\"]/div[1]/div[1]/input")));

        return itemFieldLocator.getText();
    }

}
