package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//h1[contains(text(),'New Project')]");
    public static final By PROJECT_NAME = By.id("inputTitle");
    public static final By PROJECT_CODE = By.id("inputCode");
    public static final By PROJECT_DESCRIPTION = By.id("inputDescription");
    public static final By PUBLIC_ACCESS = By.id("public-access-type");
    public static final By CREATE_BUTTON = By.xpath("//button[text()='Create project']");

    @Override
    public BasePage isPageOpened() {
        $(PAGE_TITLE).shouldBe(Condition.visible);
        return this;
    }

    public void inputProjectInfo(Project project) {
        $(PROJECT_NAME).sendKeys(project.getProjectName());
        $(PROJECT_CODE).sendKeys(project.getProjectCode());
        $(PROJECT_DESCRIPTION).sendKeys(project.getProjectDescription());
    }

    public void choosePublicAccessType() {
        $(PUBLIC_ACCESS).click();
    }

    public void createProject() {
        $(CREATE_BUTTON).click();
    }
}
