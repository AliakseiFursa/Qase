package tests;

import dto.Project;
import dto.Suite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SuiteTest extends BaseTest {

    @Test(description = "Test of creating new suite")
    public void newSuiteShouldBeCreated() {
        Project project = new Project("GoodDay", "GD21", "Very interesting project", "Public");
        Suite suite = new Suite("GoodJob", "Project root", "Hello", "World");
        loginSteps.login(EMAIL, PASSWORD);
        projectsPage.isPageOpened();
        projectSteps.createProject(project);
        assertEquals(projectPage.getProjectName(), project.getProjectName(), "Project name doesn't match");
        suiteSteps.createSuite(suite);
        newSuiteModal.isSuiteCreated();
        assertTrue(newSuiteModal.findSuite(suite), "Suite wasn't find");
    }
}
