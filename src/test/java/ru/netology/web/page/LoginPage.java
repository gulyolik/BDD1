package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    //@FindBy(css = "[data-test-id='login'] input")
    private SelenideElement loginField = $("[data-test-id='login'] input");
    //@FindBy(css = "[data-test-id='password'] input")
    private SelenideElement passwordField = $("[data-test-id='password'] input");
    //@FindBy(css = "[data-test-id='action-login']")
    private SelenideElement loginButton = $("[data-test-id='action-login']");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }


}


