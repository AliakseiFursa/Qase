package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;
import tests.base.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    NewProjectPage newProjectPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    NavigationMenuPage navigationMenuPage;
    LoginSteps loginSteps;
    ProjectSteps projectSteps;
    NewSuiteModal newSuiteModal;
    SuiteSteps suiteSteps;

    public static final String EMAIL = "alex.fursa89@gmail.com";
    public static final String PASSWORD = "FireFox_0889";

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
        navigationMenuPage = new NavigationMenuPage();
        loginSteps = new LoginSteps();
        projectSteps = new ProjectSteps();
        newSuiteModal = new NewSuiteModal();
        suiteSteps = new SuiteSteps();
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
