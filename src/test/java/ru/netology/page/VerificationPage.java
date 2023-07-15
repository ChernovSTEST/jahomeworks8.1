package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $(".notification__content");

    public void verifyVerificationPageVisibility() { codeField.shouldBe(visible); }

    public void verifyErrorNotificationVisiblity() {errorNotification.shouldBe(visible); }

    public DashboardPage validVerify(String virificationCode) {
        verify(virificationCode);
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }

}
