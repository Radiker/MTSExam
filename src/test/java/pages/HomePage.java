package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseWebTest.cfg;

public class HomePage {

    private final By TAB_ITEM_CREDIT_CARD = By.xpath("//*[text()='Кредитная карта']/ancestor::div[@eventid='widgetElementClick']");
    private final By BANNER_BUTTON = By.xpath("//a[@class='btn mts-bank__banner-button']");

    @Step("Открыть домашнюю страницу сайта")
    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    @Step("Выбрать оформление кредитной карты")
    public HomePage selectCreditCard() {
        $(TAB_ITEM_CREDIT_CARD).shouldBe(visible).scrollTo().click();
        return this;
    }

    @Step("Нажать на кнопку 'Оформить карту'")
    public HomePage clickBannerButton() {
        $(BANNER_BUTTON).shouldBe(visible).scrollTo().click();
        return this;
    }
}
