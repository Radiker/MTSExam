package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseWebTest.cfg;

public class BankCreditCardPage {

    // Контейнер заполнения персональных данных
    private final By CONTAINER_CLIENT_DATA = By.xpath("//div[@id='FABodyContainer']");
    // Поле ввода ФИО
    private final By TEXT_AREA_CLIENT_FIO = By.xpath("//textarea[@name='clientFio']");
    private final By HELP_CLIENT_FIO = By.xpath("//li[@id='react-autowhatever-1--item-0']");
    private final By HELPER_TEXT_AREA_CLIENT_FIO = By.xpath("//div[contains(@class,'hPXRpS')]//div[contains(@class,'OlnRe')]");
    // Поле ввода Даты рождения
    private final By INPUT_BIRTHDATE = By.xpath("//input[@name='birthDate']");
    private final By HELPER_INPUT_BIRTHDATE = By.xpath("//div[contains(@class,'hPXRpO')]//div[contains(@class,'OlnRe')]");
    // Поле ввода Мобильного телефона
    private final By INPUT_PHONENUMBER = By.xpath("//input[@name='phoneNumber']");
    private final By HELPER_INPUT_PHONENUMBER = By.xpath("//div[contains(@class,'PWMve')]//input[@name='phoneNumber']/ancestor::div[contains(@class,'hPXRpQ')]//div[contains(@class,'OlnRe')]");
    // Поле ввода Электронной почты
    private final By INPUT_EMAIL = By.xpath("//input[@name='email']");
    private final By HELPER_INPUT_EMAIL = By.xpath("//div[contains(@class,'PWMve')]//input[@name='email']/ancestor::div[contains(@class,'hPXRpQ')]//div[contains(@class,'OlnRe')]");
    // Флажок ознакомления с условиями
    private final By CHECKBOX = By.xpath("//div[contains(@class,'jfxywB')]//*[@data-testid='icon_baseX24/ic-check']");
    private final By HELPER_CHECKBOX = By.xpath("//div[contains(@class,'jfxywB')]//div[contains(@class,'OlnRe')]");
    // Кнопка Далее
    private final By BUTTON_NEXT_STEP = By.xpath("//button[@class='Wrapper-sc-48arcs-1 cMfwrv']");

    // Блок текста описания
    private final By CONTAINER_TEXT = By.xpath("//div[contains(@class,'fHGlSj')]");
    // Ссылка Показать все / Скрыть
    private final By TEXT_DISCLOSURE_LINK = By.xpath("//div[contains(@class,'fHGlSj')]//a[@class='LinkWrapper-sc-a7l7fm-0 eaxjcO']");
    // Свернутый текст
    private final By HIDDEN_TEXT = By.xpath("//div[contains(@class,'CGeiu')]");
    // Развернутый текст
    private final By OPENED_TEXT = By.xpath("//div[contains(@class,'hxKLtl')]");

    // Кнопки Тарифы и документы и Частые вопросы
    private final By ADDITIONAL_BUTTONS = By.xpath("//button[contains(@class,'czhqfc')]");
    //Кнопка элемента раскрывающего списка
    private final By BUTTONS_IN_DROP_DOWN_LIST = By.xpath("//div[contains(@class,'iorNyC')]//div[contains(@class,'eSyQoJ')]");
    //Кнопка элемента раскрывающего списка
    private final By TEXT_IN_DROP_DOWN_LIST = By.xpath(".//div[contains(@class,'ReactCollapse--collapse')]");

    @Step("Открыть страницу оформления кредитной карты")
    public BankCreditCardPage openPage() {
        open(cfg.bankUrl()+"/chastnim-licam/karti/credit-mts-cashback/");
        return this;
    }

    @Step("Опуститься до ввода информации")
    public BankCreditCardPage scrollToInputContainer() {
        $(CONTAINER_CLIENT_DATA).shouldBe(visible).scrollTo();
        return this;
    }

    @Step("Ввести ФИО клиента")
    public BankCreditCardPage inputClientFioToInput(String clientFio) {
        $(TEXT_AREA_CLIENT_FIO).sendKeys(clientFio);
        $(HELP_CLIENT_FIO).click();
        return this;
    }

    @Step("Ввести дату рождения")
    public BankCreditCardPage inputBirthDateToInput(String birthDate) {
        $(INPUT_BIRTHDATE).sendKeys(birthDate);
        return this;
    }

    @Step("Ввести номер телефона")
    public BankCreditCardPage inputPhoneNumberToInput(String phoneNumber) {
        $(INPUT_PHONENUMBER).sendKeys(phoneNumber);
        return this;
    }

    @Step("Ввести электронную почту")
    public BankCreditCardPage inputEmailToInput(String email) {
        $(INPUT_EMAIL).sendKeys(email);
        return this;
    }

    @Step("Нажимаем кнопку 'Далее'")
    public BankCreditCardPage clickButtonNextStep(){
        $(BUTTON_NEXT_STEP).click();
        return this;
    }

    @Step("Убираем выделение с пункта 'Я ознакомился ...'")
    public BankCreditCardPage clickCheckbox(){
        $(CHECKBOX).click();
        return this;
    }

    @Step("Проверяем заголовок текущего шага")
    public BankCreditCardPage checkHeader(String HeaderText){
        By HEADER_CONFIRMATION =  By.xpath(String.format("//h4[text()='%s']", HeaderText));
        $(HEADER_CONFIRMATION).shouldBe(visible);
        return this;
    }

    @Step("Проверяем текст ошибки ввода ФИО клиента")
    public BankCreditCardPage checkErrorTextInputClientFio(String errorText){
        $(HELPER_TEXT_AREA_CLIENT_FIO).shouldHave(text(errorText));
        return this;
    }

    @Step("Проверяем текст ошибки ввода Даты рождения")
    public BankCreditCardPage checkErrorTextInputBirthDate(String errorText){
        $(HELPER_INPUT_BIRTHDATE).shouldHave(text(errorText));
        return this;
    }

    @Step("Проверяем текст ошибки ввода Мобильного телефона")
    public BankCreditCardPage checkErrorTextInputPhoneNumber(String errorText){
        $(HELPER_INPUT_PHONENUMBER).shouldHave(text(errorText));
        return this;
    }

    @Step("Проверяем текст ошибки ввода Электронной почты")
    public BankCreditCardPage checkErrorTextInputEmail(String errorText){
        $(HELPER_INPUT_EMAIL).shouldHave(text(errorText));
        return this;
    }

    @Step("Проверяем текст ошибки выбора Флажка 'Я ознакомился ...'")
    public BankCreditCardPage checkErrorTextCheckbox(String errorText){
        $(HELPER_CHECKBOX).shouldHave(text(errorText));
        return this;
    }

    @Step("Опуститься до блока текста описания")
    public BankCreditCardPage scrollToTextContainer() {
        $(CONTAINER_TEXT).shouldBe(visible).scrollTo();
        return this;
    }

    @Step("Нажимаем 'Показать текст' / 'Скрыть'")
    public BankCreditCardPage clickTextDisclosureLink(){
        $(TEXT_DISCLOSURE_LINK).shouldBe(visible).click();
        return this;
    }

    @Step("Проверить отображение скрытого текста")
    public BankCreditCardPage checkVisibilityHiddenText(){
        $(HIDDEN_TEXT).scrollTo().shouldBe(visible);
        return this;
    }

    @Step("Проверить отображение раскрытого текста")
    public BankCreditCardPage checkVisibilityOpenedText(){
        $(OPENED_TEXT).scrollTo().shouldBe(visible);
        return this;
    }

    @Step("Открыть вкладку 'Частые вопросы'")
    public BankCreditCardPage openTabQA(){
        $$(ADDITIONAL_BUTTONS).last().shouldBe(visible).click();
        return this;
    }

    @Step("Открыть элементы в выпадающем списке")
    public BankCreditCardPage clickDropDownItems(){
        for(SelenideElement button : $$ (BUTTONS_IN_DROP_DOWN_LIST)){
            button.click();
        }
        return this;
    }

    @Step("Проверить открытые элементы в выпадающем списке")
    public BankCreditCardPage checkDropDownItemsTextExist(){
        for(SelenideElement button : $$ (BUTTONS_IN_DROP_DOWN_LIST)){
            button.find(TEXT_IN_DROP_DOWN_LIST).shouldBe(visible);
        }
        return this;

    }
}
