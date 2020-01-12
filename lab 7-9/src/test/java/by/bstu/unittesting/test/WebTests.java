package by.bstu.unittesting.test;

import by.bstu.unittesting.model.Item;
import by.bstu.unittesting.model.Order;
import by.bstu.unittesting.model.Promocode;
import by.bstu.unittesting.page.*;
import by.bstu.unittesting.service.ItemCreator;
import by.bstu.unittesting.service.OrderCreator;
import by.bstu.unittesting.service.PromoCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebTests extends GeneralConfig
{
    @Test
    public void ShopCreateTest() throws InterruptedException
    {
        Promocode testPromo = PromoCreator.createPromoWithWrongNumber();
        String errorText = new ShopCreate(driver).openPage()
                .selectOrderStatusButton()
                .selectOrderStatusButton1()
                .selectOrderStatusButton2()
                .getErrorText();
        assertThat(errorText, is(equalTo("Есть ли у Вас интернет магазин? *")));
    }

    @Test
    public void FullInfoTest() throws InterruptedException
    {
        Order testOrder = OrderCreator.FullInfoTest();
        String errorText = new FullInfo(driver).openPage()
                .selectOrderStatusButton()
                .okButton()
                .okButton1()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void PremiumTest() throws InterruptedException
    {
        Order testOrder = OrderCreator.createOrderWithWrongNumber();
        String errorText = new Premium(driver).openPage()
                .selectOrderStatusButton()
                .getErrorText();
        assertThat(errorText, is(equalTo("Оплатить подписку")));
    }

    @Test
    public void CreditTest()
    {
        String errorText = new Credit(driver).openPage()
                .openSales()
                .getErrorText();
        assertThat(errorText, is(equalTo("Покупка в кредит")));
    }

    @Test
    public void BonusTest()
    {
        String errorText = new Bonus(driver).OpBonus()
                .OpdBonus()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void MainTest()
    {
        String errorText = new MainT(driver).openPage()
                .openDelivery()
                .openManDelivery()
                .getErrorText();
        assertThat(errorText, is(equalTo("Добро пожаловать!")));
    }

    @Test
    public void NotebookFindTest()
    {
        String errorText = new NotebookFind(driver).openPage()
                .callPhoneClick()
                .submitClick()
                .getErrorText();
        assertThat(errorText, is(equalTo("Ноутбук Asus ROG Strix G531GT-BQ132 (90NR01L3-M02530) Black Суперцена!!!")));
    }

    @Test
    public void LoginTest()
    {
        Item item = ItemCreator.createViaSearch();
        String errorText = new Login(driver).openPage()
                .searchClick()
                .search(item)
                .GetItemOnPage(item)
                .searchClick1()
                .getErrorText();
        assertThat(errorText, is(equalTo("")));
    }

    @Test
    public void EmptyTest()
    {
        String errorText = new Empty(driver).openPage()
                .sendMessage()
                .getErrorText();
        assertThat(errorText, is(equalTo("Нет товаров в сравнении")));
    }

    @Test
    public void LangTest()
    {
        String errorText = new Lang(driver).openPage()
                .openPayment()
                .getErrorText();
        assertThat(errorText, is(equalTo("Ласкаво просимо!")));
    }


}
