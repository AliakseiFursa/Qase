package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage{

    public static final By NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By PROJECTS_LIST = By.xpath("//a[contains(@class,'defect-title')]");

    @Override
    public BasePage isPageOpened() {
        $(NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Override
    @Step("Opening projects page")
    public void openPage() {
        log.info("Opening projects page");
        open("projects");
    }

    @Step("Starting creation of project")
    public void clickNewProjectButton() {
        $(NEW_PROJECT_BUTTON).click();
    }

    @Step("Opening project '{projectName}'")
    public static void openProject(Project project) {
        $$(PROJECTS_LIST).findBy(text(project.getProjectName())).click();
    }
}
