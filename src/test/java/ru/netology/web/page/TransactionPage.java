package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransactionPage {
    //@FindBy(linkText = "Пополнение карты")
    private SelenideElement transactionHeading = $(byText("Пополнение карты"));
    //@FindBy(css = "[data-test-id='amount'] input")
    private SelenideElement transactionAmount =  $("[data-test-id='amount'] input");
    //@FindBy(css = "[data-test-id='from'] input")
    private SelenideElement cardForTransaction = $("[data-test-id='from'] input");
    //@FindBy(css = "[data-test-id='action-transfer']")
    private SelenideElement transactionButton = $("[data-test-id='action-transfer']");
    //@FindBy(css = "[data-test-id='action-cancel']")
    private SelenideElement cancelButton = $("[data-test-id='action-cancel']");
    //@FindBy(css = "[data-test-id='error-notification'] .notification__content")
    private SelenideElement errorMessage = $("[data-test-id='error-notification'] .notification__content");

    public TransactionPage() {
        transactionHeading.shouldBe(Condition.visible);
    }

    public DashboardPage makeValidTransaction(String amountToTransaction, DataHelper.CardInfo cardInfo) {
        makeTransaction(amountToTransaction, cardInfo);
        return new DashboardPage();
    }

    public void makeTransaction(String amountToTransaction, DataHelper.CardInfo cardInfo) {
        transactionAmount.setValue(amountToTransaction);
        cardForTransaction.setValue(cardInfo.getCardNumber());
        transactionButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(Condition.exactText(expectedText), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }


}
