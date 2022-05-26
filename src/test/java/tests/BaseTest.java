package tests;

import api.ProjectApiClient;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CaseSteps;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;
import tests.base.TestListener;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    public String user;
    public String password;
    LoginPage loginPage;
    NewProjectPage newProjectPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    NavigationMenuPage navigationMenuPage;
    LoginSteps loginSteps;
    ProjectSteps projectSteps;
    NewSuiteModal newSuiteModal;
    SuiteSteps suiteSteps;
    NewCasePage newCasePage;
    CaseSteps caseSteps;
    ProjectApiClient projectApiClient;

    @BeforeMethod(description = "Opening Browser")
    public void setUp() {
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));
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
        newCasePage = new NewCasePage();
        caseSteps = new CaseSteps();
        projectApiClient = new ProjectApiClient();
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        open();
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
