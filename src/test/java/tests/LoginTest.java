package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "Log in with correct user data")
    public void login() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login("alex.fursa89@gmail.com", "FireFox_0889");
        projectsPage.isPageOpened();
    }
}
