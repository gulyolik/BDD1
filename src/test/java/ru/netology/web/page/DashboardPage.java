package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {

    public DashboardPage() {
        SelenideElement heading = $("[data-test-id=dashboard]");
        heading.shouldBe(visible);
    }

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public void Dashboard() {
    }

    public int getCardBalance(DataHelper.CardInfo index) {
        val text = cards.get(index).getText();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransactionPage cardSelection(DataHelper.CardInfo index) {
        cards.get(index).$("button").click();
        return page(TransactionPage.class);
    }
}
