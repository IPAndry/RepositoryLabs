package framework.test;

import framework.model.LoginModel;
import framework.page.*;
import framework.service.LoginField;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebTests extends GeneralConfig
{
    @Test
    public void ShopCreateTest() throws InterruptedException
    {
        String errorText = new ShopCreate(driver)
                .openPage()
                .createShopButton()
                .fullFormButton()
                .selectCheckbox()
                .geterrortext();
        assertThat(errorText, is(equalTo("Данные о магазине")));
    }

    @Test
    public void FullInfoTest() throws InterruptedException
    {
        String errorText = new FullInfo(driver)
                .openPage()
                .notebookButton()
                .asusButton()
                .listButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void PremiumTest() throws InterruptedException
    {
        String errorText = new Premium(driver)
                .openPage()
                .getPremiumButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Оплатить подписку")));
    }

    @Test
    public void CreditTest()
    {
        String errorText = new Credit(driver)
                .openPage()
                .getCreditButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Покупка в кредит")));
    }

    @Test
    public void BonusTest()
    {
        String errorText = new Bonus(driver)
                .openPage()
                .openBonus()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void LogoTest()
    {
        String errorText = new Logo(driver)
                .openPage()
                .notebookButton()
                .logoButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Добро пожаловать!")));
    }

    @Test
    public void NotebookFindTest()
    {
        String errorText = new NotebookFind(driver)
                .openPage()
                .notebookButton()
                .asusButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void LoginTest()
    {
        LoginModel item = LoginField.createViaSearch();
        String errorText = new Login(driver)
                .openPage()
                .loginButton()
                .emailField(item)
                .passwordField(item)
                .enterAccountButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void EmptyTest()
    {
        String errorText = new Empty(driver)
                .openPage()
                .compareButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Нет товаров в сравнении\nДобавляйте товары к сравнению характеристик\nи выбирайте самый подходящий вам товар")));
    }

    @Test
    public void LangTest()
    {
        String errorText = new Lang(driver)
                .openPage()
                .ukrainianButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Ласкаво просимо!")));
    }

}
