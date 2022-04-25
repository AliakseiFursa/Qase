package pages;

import com.codeborne.selenide.Condition;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class NewSuiteModal extends BasePage {

    @Override
    public NewSuiteModal isPageOpened() {
        $("#save-suite-button").shouldBe(Condition.visible);
        return this;
    }

    @Override
    public void openPage() {
    }

    @Step("Filling suite information")
    public void fillInSuiteInformation(Suite suite) {
        log.info("Filling suite information: {}", suite);
        $("#name").sendKeys(suite.getSuiteName());
        $(byXpath("//div[contains(@class,'css-io3r9z-singleValue')]")).click();
        $("#description").sendKeys(suite.getDescription());
        $("#preconditions").sendKeys(suite.getPreconditions());
    }

    @Step("Creating new suite")
    public void createSuite() {
        $("#save-suite-button").click();
    }

    @Step("Checking that suite was created")
    public NewSuiteModal isSuiteCreated() {
        $(byXpath("//div[contains(@class,'flash-message')]")).shouldHave(Condition.text("Suite was successfully created."));
        return this;
    }

    @Step("Finding suite in suite list")
    public boolean findSuite(Suite suite) {
        return $$(byXpath("//a[contains(@class,'style_title-1ehyC')]")).findBy(Condition.text(suite.getSuiteName())).isDisplayed();
    }
}
