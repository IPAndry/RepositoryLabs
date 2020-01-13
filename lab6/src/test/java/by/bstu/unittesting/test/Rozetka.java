package by.bstu.unittesting.test;

import by.bstu.unittesting.page.CityChange;
import by.bstu.unittesting.page.Autoriz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

public class Rozetka {

    private static final String NEXT_DAY_OF_MONTH
            = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testIncorrectPhone() {

        Autoriz callPhonePahe = new Autoriz(driver)
                .openPage()
                .login_Button()
                .mail("ipnadry@gmail.com")
                .pass("1q2w3eTetris")
                .loginAccount();

        assertTrue(callPhonePahe.getErrorText().contains("Вход в интернет-магазин"));
    }
    @Test
    public void testEnteringEmptyMessage() {

        CityChange sendMessagePage = new CityChange(driver)
                .openPage()
                .annoying()
                .changeCity()
                .insertCity("БГТУ");

        assertTrue(sendMessagePage.getErrorText().contains("Город не найден."));
    }

    @After
    public void after() {
        driver.close();
    }
}
