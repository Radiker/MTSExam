package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BankCreditCardPage;
import pages.HomePage;

public class IssueCreditCardTest extends BaseWebTest{

    @Test
    @DisplayName("Проверка приема ввода корректных данных при оформлении карты")
    public void checkingFillCorrectDataInCardOrderForm() {
        HomePage homePage = new HomePage();
        homePage
            .openPage()
            .selectCreditCard()
            .clickBannerButton();

        BankCreditCardPage bankCreditCardPage = new BankCreditCardPage();
        bankCreditCardPage
            .scrollToInputContainer()
            .inputClientFioToInput("Иванов Иван Иванович")
            .inputBirthDateToInput("29022000")
            .inputPhoneNumberToInput("9000000000")
            .inputEmailToInput("mail@example.com")
            .clickButtonNextStep()
            .checkHeader("Подтвердите номер телефона");
    }

    @Test
    @DisplayName("Проверка приема ввода пустых данных при оформлении карты")
    public void checkingFillEmptyDataInCardOrderForm() {
        BankCreditCardPage bankCreditCardPage = new BankCreditCardPage();
        bankCreditCardPage
            .openPage()
            .scrollToInputContainer()
            .clickButtonNextStep()
            .checkErrorTextInputClientFio("Введите ФИО полностью")
            .checkErrorTextInputBirthDate("Обязательное поле")
            .checkErrorTextInputPhoneNumber("Обязательное поле");
    }

    @Test
    @DisplayName("Проверка приема ввода неверных данных при оформлении карты")
    public void checkingFillIncorrectDataInCardOrderForm() {
        BankCreditCardPage bankCreditCardPage = new BankCreditCardPage();
        bankCreditCardPage
            .openPage()
            .scrollToInputContainer()
            .clickButtonNextStep()
            .inputClientFioToInput("Иванов")
            .inputBirthDateToInput("29022020")
            .inputPhoneNumberToInput("900000000")
            .inputEmailToInput("mailexample.com")
            .clickCheckbox()
            .clickButtonNextStep()
            .checkErrorTextInputClientFio("Введите ФИО полностью")
            .checkErrorTextInputBirthDate("Возраст клиента должен быть не менее 20 лет")
            .checkErrorTextInputPhoneNumber("Введите верный номер телефона")
            .checkErrorTextInputEmail("Введите верный электронный адрес")
            .checkErrorTextCheckbox("Установите этот флажок");
    }

    @Test
    @DisplayName("Проверка приема ввода неверных данных при оформлении карты")
    public void checkingTextDisclosureInCardOrderForm() {
        BankCreditCardPage bankCreditCardPage = new BankCreditCardPage();
        bankCreditCardPage
            .openPage()
            .scrollToTextContainer()
            .checkVisibilityHiddenText()
            .clickTextDisclosureLink()
            .checkVisibilityOpenedText()
            .clickTextDisclosureLink()
            .checkVisibilityHiddenText();
    }

    @Test
    @DisplayName("Проверка открытия нескольких элементов выпадающего списка 'Частые вопросы'")
    public void checkingOpenedMultipleDropdownItems() {
        BankCreditCardPage bankCreditCardPage = new BankCreditCardPage();
        bankCreditCardPage
            .openPage()
            .openTabQA()
            .clickDropDownItems()
            .checkDropDownItemsTextExist();
    }
}