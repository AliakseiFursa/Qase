package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectPage;
import pages.ProjectsPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    NewProjectPage newProjectPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;

    @BeforeMethod(description = "Opening Browser")
    public void setUp() {
        Configuration.baseUrl = "http://qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        loginPage = new LoginPage();
        newProjectPage = new NewProjectPage();
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
