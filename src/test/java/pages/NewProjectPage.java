package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final By PAGE_TITLE = By.xpath("//h1[contains(text(),'New Project')]");
    public static final By PROJECT_NAME = By.id("inputTitle");
    public static final By PROJECT_CODE = By.id("inputCode");
    public static final By PROJECT_DESCRIPTION = By.id("inputDescription");
    public static final By PUBLIC_ACCESS = By.id("public-access-type");
    public static final By PRIVATE_ACCESS = By.id("private-access-type");
    public static final By CREATE_BUTTON = By.xpath("//button[text()='Create project']");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class,'form-control-feedback')]");

    @Override
    public BasePage isPageOpened() {
        $(PAGE_TITLE).shouldBe(Condition.visible);
        return this;
    }

    @Override
    @Step("Opening new project page")
    public void openPage() {
    }

    @Step("Filling project information")
    public void inputProjectInfo(Project project) {
        log.info("Creation of project {}", project.getName());
        $(PROJECT_NAME).sendKeys(project.getName());
        $(PROJECT_CODE).sendKeys(project.getCode());
        $(PROJECT_DESCRIPTION).sendKeys(project.getDescription());
    }

    @Step("Setting access type")
    public void setAccessType(Project project) {
        log.info("Setting access type to '{}'", project.getAccessType());
        if (project.getAccessType().equalsIgnoreCase("Public")) {
            $(PUBLIC_ACCESS).click();
        } else if (project.getAccessType().equalsIgnoreCase("Private")) {
            $(PRIVATE_ACCESS).click();
        }
    }

    @Step("Creation of project")
    public void createProject() {
        $(CREATE_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return $(ERROR_MESSAGE).getText();
    }
}
