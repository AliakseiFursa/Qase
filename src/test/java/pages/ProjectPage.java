package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage extends BasePage {

    public static final By PROJECT_HEADER = By.xpath("//p[contains(@class, 'header')]");

    @Override
    public ProjectPage isPageOpened() {
        $(PROJECT_HEADER).shouldBe(Condition.visible);
        return this;
    }

    @Override
    @Step("Opening project page")
    public void openPage() {
    }

    @Step("Getting project name")
    public String getProjectName() {
        return $(PROJECT_HEADER).getText();
    }

    @Step("Creating new suite")
    public void clickNewSuiteButton() {
        $("#create-suite-button").click();
    }
}
