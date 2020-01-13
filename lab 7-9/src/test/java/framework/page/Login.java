package framework.page;

import framework.model.LoginModel;
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

    private final Logger logger = LogManager.getLogger(Login.class);

    @FindBy(xpath = "//*[@name='login']")
    private WebElement search;

    @FindBy(xpath = "//*[not(@tabindex='2') and @type='password']")
    private WebElement search1;

    @FindBy(xpath = "//*[@name='login']")
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

    public Login loginButton() {
        WebElement search = driver.findElement(By.xpath("//*[@id='header_user_menu_parent']"));
        search.click();
        logger.info("Click Login");
        return this;
    }

    public Login emailField(LoginModel item) {
        search.sendKeys(item.getSearch());
        logger.info("Email input");
        return this;
    }

    public Login passwordField(LoginModel item) {
        search1.sendKeys(item.getSearch());
        logger.info("Password input");
        return this;
    }

    public Login enterAccountButton() {
        WebElement search = driver.findElement(By.xpath("//button[@class='btn-link-i' and text()='Войти']"));
        search.click();
        logger.info("Login button");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='login']")));

        return itemFieldLocator.getText();
    }
}
