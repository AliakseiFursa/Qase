package pages;

import com.codeborne.selenide.Condition;
import dto.Case;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import wrappers.DropDown;
import wrappers.Input;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewCasePage extends BasePage {

    public static final By SAVE_BUTTON = By.id("save-case");

    @Override
    public NewCasePage isPageOpened() {
        $(SAVE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Override
    public void openPage() {
    }

    @Step("Filling case information")
    public void fillInCaseInformation(Case newCase) {
        $("#title").sendKeys(newCase.getTitle());
        new Input("Description").write(newCase.getDescription());
        new DropDown("Status").select(newCase.getStatus());
        new DropDown("Suite").select(newCase.getSuite());
        new DropDown("Severity").select(newCase.getSeverity());
        new DropDown("Priority").select(newCase.getPriority());
        new DropDown("Type").select(newCase.getType());
        new DropDown("Layer").select(newCase.getLayer());
        new DropDown("Is Flaky").select(newCase.getIsFlaky());
        new DropDown("Milestone").select(newCase.getMilestone());
        new DropDown("Behavior").select(newCase.getBehavior());
        new DropDown("Automation status").select(newCase.getAutomationStatus());
        new Input("Pre-conditions").write(newCase.getPreconditions());
        new Input("Post-conditions").write(newCase.getPostconditions());
    }

    @Step("Creating new case")
    public void createCase() {
        $(SAVE_BUTTON).click();
    }

    @Step("Checking that case was created")
    public NewCasePage isCaseCreated() {
        $(byXpath("//span[contains(@class, 'alert-message')]")).shouldHave(Condition.text("Test case was created successfully!"));
        return this;
    }

    @Step("Looking for case")
    public boolean findCase(Case newCase) {
        return $$(byXpath("//div[contains(@class, 'style_node-1xyzW')]")).findBy(Condition.text(newCase.getTitle())).isDisplayed();
    }
}