package by.bstu.unittesting.test;

import by.bstu.unittesting.model.Item;
import by.bstu.unittesting.model.Order;
import by.bstu.unittesting.model.Phone;
import by.bstu.unittesting.model.Promocode;
import by.bstu.unittesting.page.*;
import by.bstu.unittesting.service.ItemCreator;
import by.bstu.unittesting.service.OrderCreator;
import by.bstu.unittesting.service.PhoneCreator;
import by.bstu.unittesting.service.PromoCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebTests extends GeneralConfig {


    private static final String ALPHABET_PAGE_ERROR_TEXT = "Поле Номер заказа должно содержать только цифры.";
    private static final String NUMBER_PAGE_ERROR_TEXT = "Возможно, Вы ошиблись в номере заказа?";
    private static final String PROMO_PAGE_ERROR_TEXT = "Такого промокода не существует";


    @Test
    public void testWrongPromo() throws InterruptedException {


        Promocode testPromo = PromoCreator.createPromoWithWrongNumber();
        String errorText = new IncorrectPromoPage(driver).openPage()
                .selectOrderStatusButton()
                .selectOrderStatusButton1()
                .selectOrderStatusButton2()
                .getErrorText();

        assertThat(errorText, is(equalTo("Есть ли у Вас интернет магазин? *")));

    }

    @Test
    public void testAlphabetInNumberField() throws InterruptedException {


        Order testOrder = OrderCreator.createOrderWithAllFieldsFromProperty();

        String errorText = new OrderPage(driver).openPage()
                .selectOrderStatusButton()
                .okButton()
                .okButton1()
                .getErrorText();

        assertThat(errorText, is(equalTo("")));

    }

    @Test
    public void testIncorrectOrder() throws InterruptedException {


        Order testOrder = OrderCreator.createOrderWithWrongNumber();

        String errorText = new IncorrectOrderPage(driver).openPage()
                .selectOrderStatusButton()
                .getErrorText();

        assertThat(errorText, is(equalTo("Оплатить подписку")));

    }

    @Test
    public void testSales() {

        String errorText = new SalesPage(driver).openPage()
                .openSales()

                .getErrorText();

        assertThat(errorText, is(equalTo("Покупка в кредит")));

    }

    @Test
    public void testInstallment() {

        String errorText = new InstallmentPage(driver).openPage()
                .openInstallment()
                .getErrorText();

        assertThat(errorText, is(equalTo("")));

    }


    @Test
    public void testDeliveryCost() {

        String errorText = new DeliveryPage(driver).openPage()
                .openDelivery()
                .openManDelivery()
                .getErrorText();

        assertThat(errorText, is(equalTo("Регистрация")));

    }

    @Test
    public void testIncorrectPhone() {

        Phone testPhone = PhoneCreator.createPhoneWithWrongNumber();
        String errorText = new CallPhonePage(driver).openPage()
                .callPhoneClick()
                .submitClick()
                .getErrorText();

        assertThat(errorText, is(equalTo(" Ноутбук Asus ROG Strix G531GT-BQ027 (90NR01L3-M02610) Black Суперцена!!! ")));

    }

    @Test
    public void testGraver() {

        Item item = ItemCreator.createViaSearch();
        String errorText = new SearchGraver(driver).openPage()
                .search(item)
                .searchClick()
                .GetItemOnPage(item)
                .getErrorText();


        assertThat(errorText, is(equalTo(item.getName())));
    }

    @Test
    public void testEnteringEmptyMessage() {

        Phone testPhone = PhoneCreator.createPhoneWithEmptyNumber();
        String errorText = new EmptyMessagePage(driver).openPage()
                .sendMessage()
                .typeOrigin()
                .getErrorText();

        assertThat(errorText, is(equalTo("Поле \"Сообщение\" обязательно для заполнения.\nДолжно быть указано хотя бы что-то одно: телефон и/или email.")));
    }

    @Test
    public void testRubbles() {

        String errorText = new PaymentPage(driver).openPage()
                .openPayment()
                .getErrorText();

        assertThat(errorText, is(equalTo("Зв'язок із соціальними мережами")));

    }


}
