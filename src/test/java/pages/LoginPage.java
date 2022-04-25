package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {

    public static final By EMAIL = By.id("inputEmail");
    public static final By PASSWORD = By.id("inputPassword");
    public static final By LOGIN_BUTTON = By.id("btnLogin");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class,'form-control-feedback')]");

    @Override
    public LoginPage isPageOpened() {
        $(LOGIN_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Override
    @Step("Opening login page")
    public void openPage() {
        log.info("Opening login page");
        open("login");
    }

    @Step("Log in with login - '{email}' and password - '{password}'")
    public void login(String email, String password) {
        log.info("Log in with login - '{}' and password - '{}'", email, password);
        $(EMAIL).sendKeys(email);
        $(PASSWORD).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return $(ERROR_MESSAGE).getText();
    }
}
