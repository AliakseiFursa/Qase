package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    public static final By EMAIL = By.id("inputEmail");
    public static final By PASSWORD = By.id("inputPassword");
    public static final By LOGIN_BUTTON = By.id("btnLogin");

    @Override
    public LoginPage isPageOpened() {
        $(LOGIN_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public void openPage() {
        open("login");
    }

    public void login(String email, String password) {
        $(EMAIL).sendKeys(email);
        $(PASSWORD).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }
}
