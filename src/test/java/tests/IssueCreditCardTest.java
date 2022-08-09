package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BankPage;
import pages.HomePage;

public class IssueCreditCardTest extends BaseWebTest{

    @Test
    @DisplayName("Корректность приема ввода данных при оформлении карты")
    public void checkingFillCorrectDataInCardOrderForm() {
        HomePage homePage = new HomePage();
        homePage
            .openPage()
            .selectCreditCard()
            .clickBannerButton();

        BankPage bankPage = new BankPage();
        bankPage
            .scrollToInputContainer()
            .inputClientFioToInput("Иванов Иван Иванович")
            .inputBirthDateToInput("29022000")
            .inputPhoneNumberToInput("9000000000")
            .inputEmailToInput("mail@example.com")
            .clickButtonNextStep()
            .checkHeader("Подтвердите номер телефона");

    }



}
