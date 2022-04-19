package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage{

    public static final By NEW_PROJECT_BUTTON = By.id("createButton");

    @Override
    public BasePage isPageOpened() {
        $(NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public void clickNewProjectButton() {
        $(NEW_PROJECT_BUTTON).click();
    }
}
