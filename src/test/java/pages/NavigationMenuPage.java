package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationMenuPage extends BasePage {

    public static final By LOGO = By.id("Logo");
    public static final By PROJECTS = By.xpath("//span[contains(text(),'Projects')]");

    @Override
    public NavigationMenuPage isPageOpened() {
        $(LOGO).shouldBe(Condition.visible);
        return this;
    }

    @Override
    public void openPage() {
    }

    @Step("Opening projects page")
    public void openProjectsPage() {
        log.info("Opening projects page");
        $(PROJECTS).click();
    }
}
