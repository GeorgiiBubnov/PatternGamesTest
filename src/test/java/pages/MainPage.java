package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Language;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final ElementsCollection menuButtons = $$("div.header__links a");

    private final SelenideElement chooseLanguageButton = $(".header__block_locale"),
            titleOfMainPage = $("div.question__list__title"),
            addProjectButton = $(".header__buttons"),
            linkPolicy = $(".contacts__feedback").$(".link-blue"),
            subtitle = $("div.home__project_slider__title"),
            careerMenuButton = $("a[href=\"/career\"]"),
            projectMenuButton = $("a[href=\"/projects\"]");
    

    @Step("Открыть главную страницу")
    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Нажать на кнопку выбора языка")
    public MainPage clickLanguageButton() {
        chooseLanguageButton.click();
        return this;
    }

    @Step("Выбрать язык {0}")
    public MainPage chooseLanguage(Language language) {
        chooseLanguageButton.$(byText(language.name())).shouldBe(visible).click();
        return this;
    }

    @Step("Выбрать язык {0} для проверки подзаголовка")
    public MainPage chooseLanguage(String language) {
        chooseLanguageButton.$(byText(language)).shouldBe(visible).click();
        return this;
    }

    @Step("Проверка заголовка главной страницы на языке {0}")
    public MainPage checkTitleOfMainPage(Language language) {
        titleOfMainPage.shouldHave(text(language.description));
        return this;
    }

    @Step("Проверка кнопок меню {0}")
    public MainPage checkButtonsOfMenu(List<String> expectedButtons) {
        menuButtons.shouldHave(texts(expectedButtons));
        return this;
    }

    @Step("Проверка подзаголовка главной страницы {0}")
    public MainPage checkSubtitleOfMainPage(String title) {
        subtitle.shouldHave(text(title));
        return this;
    }

    @Step("Нажать на кнопку 'Запуск проекта'")
    public MainPage clickAddProjectButton() {
        addProjectButton.click();
        return this;
    }

    @Step("Нажать на ссылку 'Политика конфиденциальности'")
    public MainPage clickLinkPolicy() {
        linkPolicy.shouldHave(text("Политикой конфиденциальности")).click();
        switchTo().window(1);
        return this;
    }

    @Step("Нажать на кнопку 'Карьера'")
    public MainPage clickCareerMenuButton() {
        careerMenuButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Проекты'")
    public MainPage clickProjectMenuButton() {
        projectMenuButton.click();
        return this;
    }



}

