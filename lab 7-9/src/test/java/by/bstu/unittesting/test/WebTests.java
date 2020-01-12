package by.bstu.unittesting.test;

import by.bstu.unittesting.model.LoginModel;
import by.bstu.unittesting.page.*;
import by.bstu.unittesting.service.LoginField;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebTests extends GeneralConfig
{
    @Test
    public void ShopCreateTest() throws InterruptedException
    {
        String errorText = new ShopCreate(driver).openPage()
                .CreateShopButton()
                .FullFormButton()
                .SelectCheckbox()
                .getErrorText();
        assertThat(errorText, is(equalTo("Есть ли у Вас интернет магазин? *")));
    }

    @Test
    public void FullInfoTest() throws InterruptedException
    {
        String errorText = new FullInfo(driver).openPage()
                .NotebookButton()
                .AsusButton()
                .ListButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void PremiumTest() throws InterruptedException
    {
        String errorText = new Premium(driver).openPage()
                .GetPremiumButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Оплатить подписку")));
    }

    @Test
    public void CreditTest()
    {
        String errorText = new Credit(driver).openPage()
                .GetCreditButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Покупка в кредит")));
    }

    @Test
    public void BonusTest()
    {
        String errorText = new Bonus(driver).OpBonus()
                .OpenBonus()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void MainTest()
    {
        String errorText = new MainT(driver).openPage()
                .NotebookButton()
                .LogoButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Добро пожаловать!")));
    }

    @Test
    public void NotebookFindTest()
    {
        String errorText = new NotebookFind(driver).openPage()
                .NotebookButton()
                .AsusButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Ноутбук Asus ROG Strix G531GT-BQ132 (90NR01L3-M02530) Black Суперцена!!!")));
    }

    @Test
    public void LoginTest()
    {
        LoginModel item = LoginField.createViaSearch();
        String errorText = new Login(driver).openPage()
                .LoginButton()
                .EmailField(item)
                .PasswordField(item)
                .EnterAccountButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void EmptyTest()
    {
        String errorText = new Empty(driver).openPage()
                .CompareButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Нет товаров в сравнении")));
    }

    @Test
    public void LangTest()
    {
        String errorText = new Lang(driver).openPage()
                .UkrainianButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Ласкаво просимо!")));
    }


}
