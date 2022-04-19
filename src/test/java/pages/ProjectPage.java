package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage extends BasePage{

    public static final By PROJECT_HEADER = By.xpath("//p[contains(@class, 'header')]");
    @Override
    public ProjectPage isPageOpened() {
        $(PROJECT_HEADER).shouldBe(Condition.visible);
        return this;
    }

    public String getProjectName() {
        return $(PROJECT_HEADER).getText();
    }
}
