package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class NarcosGamePage {

    private final SelenideElement googlePlayButton = $("a[href=\"https://play.google.com/store/apps/details?id=com.ftxgames.narcos\"]");

    @Step("Нажать ссылку на GooglePlay")
    public NarcosGamePage clickGooglePlayButton() {
        googlePlayButton.click();
        switchTo().window(1);
        return this;
    }
}
