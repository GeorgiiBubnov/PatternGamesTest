package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GooglePlayPage {

    private final SelenideElement titleOfCurrentPage = $("h1");

    @Step("Проверка заголовка {0}")
    public GooglePlayPage checkTitleOfCurrentPage(String title) {
        titleOfCurrentPage.shouldHave(text(title));
        return this;
    }
}
