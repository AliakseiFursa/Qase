package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Log in with correct user data")
    public void correctUserShouldBeLoggedIn() {
        loginSteps.login(EMAIL, PASSWORD);
        projectsPage.isPageOpened();
    }

    @Test(description = "Getting error message while logging in with incorect data")
    public void errorMessageShouldBeDisplayed() {
        loginSteps.login("eing_khan@796.56.sharelane.com", "dvdvdb");
        assertEquals(loginPage.getErrorMessage(), "These credentials do not match our records.", "Error message didn't match");
    }
}
