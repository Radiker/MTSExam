package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BankCreditCardPage;
import pages.BankPurchasesPage;

import java.util.ArrayList;

public class CorrectTextPurchasesTest extends BaseWebTest{
    @Test
    @DisplayName("Проверка корректности года в тексте")
    public void checkingFillEmptyDataInCardOrderForm() {
        BankPurchasesPage bankPurchasesPage = new BankPurchasesPage();
        bankPurchasesPage.openPage();
        ArrayList<String> years = bankPurchasesPage.getListYear();
        for (String year : years) {
            bankPurchasesPage = new BankPurchasesPage();
            bankPurchasesPage
                .openPage(year)
                .checkYearInActiveLink(year)
                .checkYearInText(year)
                .clickNextActiveLink();
        }
    }
}
