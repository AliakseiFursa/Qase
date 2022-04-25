package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Log in with login - '{email}' and password - '{password}'")
    public void login(String email, String password) {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(email, password);
    }
}
