package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ProjectPage {

    private final SelenideElement  narcosGameButton = $("a[href=\"/projects/narcos-cartel-wars\"]");

    @Step("Нажать на проект 'Narcos'")
    public ProjectPage clickNarcosGameButton() {
        narcosGameButton.click();
        switchTo().window(1);
        return this;
    }

}
