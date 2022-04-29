package tests;

import dto.Case;
import dto.Project;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CaseTest extends BaseTest {

    @Test(description = "Test of creating new case")
    public void newCaseShouldBeCreated() {
        Project project = new Project("BadDay", "BD21", "Not so interesting project", "Public");
        Case newCase = new Case("Hallo", "Actual", "No description", "Test cases without suite",
                "Normal", "Not set", "Other", "Not set", "No", "Not set",
                "Not set", "Not automated", "No", "No");
        loginSteps.login(user, password);
        projectsPage.isPageOpened();
        projectSteps.createProject(project);
        assertEquals(projectPage.getProjectName(), project.getName(), "Project name doesn't match");
        caseSteps.createCase(newCase);
        newCasePage.isCaseCreated();
        assertTrue(newCasePage.findCase(newCase), "Case wasn't found");
    }
}
