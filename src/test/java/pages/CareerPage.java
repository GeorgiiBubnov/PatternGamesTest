package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CareerPage {

    private final SelenideElement titleOfCurrentPage = $(".career__vacancies_empty");

    @Step("Нажать на кнопку 'Карьера'")
    public CareerPage checkTitleOfCareerPage(String title) {
        titleOfCurrentPage.shouldHave(text(title));
        return this;
    }


}
