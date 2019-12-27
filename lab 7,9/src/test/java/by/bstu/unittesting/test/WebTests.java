package by.bstu.unittesting.test;

import by.bstu.unittesting.model.Order;
import by.bstu.unittesting.model.Promocode;
import by.bstu.unittesting.page.IncorrectOrderPage;
import by.bstu.unittesting.page.IncorrectPromoPage;
import by.bstu.unittesting.page.OrderPage;
import by.bstu.unittesting.service.OrderCreator;
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


}
