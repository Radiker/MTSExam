package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseWebTest.cfg;

public class BankPage {

    private final By CONTAINER_CLIENT_DATA = By.xpath("//div[@id='FABodyContainer']");

    private final By TEXT_AREA_CLIENT_FIO = By.xpath("//textarea[@name='clientFio']");
    private final By HELP_CLIENT_FIO = By.xpath("//li[@id='react-autowhatever-1--item-0']");
    //Error text
    //<div data-testid="text" color="#EB4A13" class="Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf">Введите ФИО полностью</div>

    private final By INPUT_BIRTHDATE = By.xpath("//input[@name='birthDate']");
    //Error text
    //<div data-testid="text" color="#EB4A13" class="Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf">Возраст клиента должен быть не менее 20 лет</div>

    private final By INPUT_PHONENUMBER = By.xpath("//input[@name='phoneNumber']");
    //Error text
    //<div data-testid="text" color="#EB4A13" class="Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf">Введите верный номер телефона</div>

    private final By INPUT_EMAIL = By.xpath("//input[@name='email']");
    //Error text
    //<div data-testid="text" color="#EB4A13" class="Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf">Введите верный электронный адрес</div>

    //<svg width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="currentColor" data-testid="icon_baseX24/ic-check" class="Svg-sc-1cvehoj-1 gEwQyG"><path fill-rule="evenodd" clip-rule="evenodd" d="M18.718 7.304a1 1 0 01-.022 1.414l-8.25 8a1 1 0 01-1.392 0l-3.75-3.636a1 1 0 111.392-1.436l3.054 2.961 7.554-7.325a1 1 0 011.414.022z"></path></svg>
    //Error text
    //<div data-testid="text" color="#EB4A13" class="Wrapper-sc-1vydk7-0 OlnRe HelperText-sc-jsokzo-0 hByJHf">Установите этот флажок</div>
    //.laHSjE > .Svg-sc-1cvehoj-1
    //<svg width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="currentColor" data-testid="icon_baseX24/ic-check" class="Svg-sc-1cvehoj-1 gEwQyG"><path fill-rule="evenodd" clip-rule="evenodd" d="M18.718 7.304a1 1 0 01-.022 1.414l-8.25 8a1 1 0 01-1.392 0l-3.75-3.636a1 1 0 111.392-1.436l3.054 2.961 7.554-7.325a1 1 0 011.414.022z"></path></svg>

    private final By BUTTON_NEXT_STEP = By.xpath("//button[@class='Wrapper-sc-48arcs-1 cMfwrv']");

    @Step("Открыть домашнюю страницу сайта")
    public BankPage openPage() {
        open(cfg.bankUrl());
        return this;
    }

    @Step("Опуститься до ввода информации")
    public BankPage scrollToInputContainer() {
        $(CONTAINER_CLIENT_DATA).shouldBe(visible).scrollTo();
        return this;
    }

    @Step("Ввести ФИО клиента")
    public BankPage inputClientFioToInput(String clientFio) {
        $(TEXT_AREA_CLIENT_FIO).sendKeys(clientFio);
        $(HELP_CLIENT_FIO).click();
        return this;
    }

    @Step("Ввести дату рождения")
    public BankPage inputBirthDateToInput(String birthDate) {
        $(INPUT_BIRTHDATE).sendKeys(birthDate);
        return this;
    }

    @Step("Ввести номер телефона")
    public BankPage inputPhoneNumberToInput(String phoneNumber) {
        $(INPUT_PHONENUMBER).sendKeys(phoneNumber);
        return this;
    }

    @Step("Ввести электронную почту")
    public BankPage inputEmailToInput(String email) {
        $(INPUT_EMAIL).sendKeys(email);
        return this;
    }

    @Step("Нажимаем кнопку 'Далее'")
    public BankPage clickButtonNextStep(){
        $(BUTTON_NEXT_STEP).click();
        return this;
    }

    @Step("Проверяем заголовок текущего шага")
    public BankPage checkHeader(String HeaderText){
        By HEADER_CONFIRMATION =  By.xpath(String.format("//h4[text()='%s']", HeaderText));
        $(HEADER_CONFIRMATION).shouldBe(visible);
        return this;
    }
}
