package tests;

import data.Language;
import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;


import java.util.List;
import java.util.stream.Stream;

import static data.TestData.*;


public class PatternGamesTests extends TestBase {

    TestData testData = new TestData();
    MainPage mainPage = new MainPage();
    PolicyPage policyPage = new PolicyPage();
    CareerPage careerPage = new CareerPage();
    ProjectPage projectPage = new ProjectPage();
    NarcosGamePage narcosGamePage = new NarcosGamePage();
    GooglePlayPage googlePlayPage = new GooglePlayPage();



    @EnumSource(Language.class)
    @Tag("smoke")
    @ParameterizedTest(name = "Проверка заголовка на соответствующем языке {0}")
    @DisplayName("Проверка заголовка на соответствующем языке {0}")
    void checkTitleOnOtherLanguagesTest(Language language) {
        mainPage.openPage("/")
                .clickLanguageButton()
                .chooseLanguage(language)
                .checkTitleOfMainPage(language);

    }

    static Stream<Arguments> patternSiteShouldBeCorrectButtonsTest() {
        return Stream.of(
                Arguments.of(Language.RU,
                        List.of("О нас", "Проекты", "Услуги", "Карьера", "Контакты")
                ),
                Arguments.of(Language.EN,
                        List.of("About Us", "Projects", "Services", "Contacts")
                ),
                Arguments.of(Language.HY,
                        List.of("Մեր մասին", "Նախագծեր", "Ծառայություններ", "Հետադարձ կապ")
                )
        );
    }

    @MethodSource
    @Tag("smoke")
    @ParameterizedTest(name = "Проверка наличия кнопок {1} на соответствующем языке {0}")
    @DisplayName("Проверка наличия кнопок {1} на соответствующем языке {0}")
    void patternSiteShouldBeCorrectButtonsTest(Language language, List<String> expectedButtons) {
        mainPage.openPage("/")
                .clickLanguageButton()
                .chooseLanguage(language)
                .checkButtonsOfMenu(expectedButtons);


    }

    @CsvFileSource(resources = "/test_data/checkTitleOnOtherLanguagesWithFile.csv")
    @Tag("smoke")
    @ParameterizedTest(name = "Проверка подзаголовка {1} на соответствующем языке {0}")
    @DisplayName("Проверка подзаголовка {1} на соответствующем языке {0}")
    void checkTitleOnOtherLanguagesWithCSVFileTest(String language, String title) {
        mainPage.openPage("/")
                .clickLanguageButton()
                .chooseLanguage(language)
                .checkSubtitleOfMainPage(title);
    }

    @Test
    @Tag("web")
    @DisplayName("Проверка заголовка Политики конфиденциальности")
    void checkPrivatePolicyTest() {
        mainPage.openPage("/")
                .clickAddProjectButton()
                .clickLinkPolicy();
        policyPage.checkTitleOfCurrentPage(TITLE_OF_POLICY_PAGE);

    }

    @Test
    @Tag("web")
    @DisplayName("Проверка отсутствия вакансий")
    void checkTitleOfVacancyTest() {
        mainPage.openPage("/")
                .clickCareerMenuButton();
        careerPage.checkTitleOfCareerPage(TITLE_OF_CAREER_PAGE);

    }

    @Test
    @Tag("web")
    @DisplayName("Проверка наличия игры на GooglePlay")
    void checkNameOfGameOnGooglePlayTest() {
        mainPage.openPage("/")
                .clickProjectMenuButton();
        projectPage.clickNarcosGameButton();
        narcosGamePage.clickGooglePlayButton();
        googlePlayPage.checkTitleOfCurrentPage(TITLE_OF_GAME);


    }
}
