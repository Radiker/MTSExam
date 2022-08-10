package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.annotation.Nullable;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseWebTest.cfg;

public class BankPurchasesPage {

    private final By YEAR_LINKS = By.xpath("//ul[@class='year-list']/li/a[text()]");
    private final By YEAR_ACTIVE_LINK = By.xpath("//ul[@class='year-list']/li/a[@class='active']");
    private final By YEAR_NEXT_ACTIVE_LINK = By.xpath("//ul[@class='year-list']/li/a[@class='active']/parent::li/following-sibling::li/a[text()]");
    private final By HEADERS_WITH_YEAR = By.xpath("//div[@class='item__date small']");

    @Step("Открыть страницу закупок")
    public BankPurchasesPage openPage() {
        open(cfg.bankUrl()+"/o-banke/zakupki/");
        return this;
    }
    @Step("Открыть страницу закупок")
    public BankPurchasesPage openPage(String year) {
        open(cfg.bankUrl()+"/o-banke/zakupki/" + year);
        return this;
    }

    @Step("Получить список доступных лет")
    public ArrayList<String> getListYear() {
        ArrayList<String> result = new ArrayList<String>();
        for(SelenideElement year : $$(YEAR_LINKS)){
            result.add(year.getText());
        }
        return result;
    }

    @Step("Проверить активный год закупки в актуальной ссылке")
    public BankPurchasesPage checkYearInActiveLink(String year) {
        $(YEAR_ACTIVE_LINK).shouldBe(visible).shouldHave(text(year));
        return this;
    }

    @Step("Проверить активный год закупки в тексте")
    public BankPurchasesPage checkYearInText(String year) {
        for (SelenideElement header : $$(HEADERS_WITH_YEAR)) {
            header.shouldHave(text(year));
        }
        return this;
    }

    @Step("Проверить активный год закупки в актуальной ссылке")
    public BankPurchasesPage clickNextActiveLink() {
        if($(YEAR_NEXT_ACTIVE_LINK).exists())
            $(YEAR_NEXT_ACTIVE_LINK).shouldBe(visible).click();
        return this;
    }
}
