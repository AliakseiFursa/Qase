package tests;

import dto.Project;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest {

    @Test(description = "Creation of new project")
    public void createNewProject() {
        Project project = new Project("GoodDay", "GD21", "Very interesting project", "Public");
        loginSteps.login(EMAIL, PASSWORD);
        projectsPage.isPageOpened();
        projectSteps.createProject(project);
        projectPage.isPageOpened();
        assertEquals(projectPage.getProjectName(), project.getProjectName(), "Project name doesn't match");
    }

    @Test(description = "Getting an error message when project name is longer than 255 characters")
    public void createLongTitle() {
        Project project = new Project("erferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfref" +
                "regerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerf" +
                "erfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefregerferfrefr",
                "GD21", "Very interesting project", "Public");
        loginSteps.login(EMAIL, PASSWORD);
        projectsPage.isPageOpened();
        projectSteps.createProject(project);
        assertEquals(newProjectPage.getErrorMessage(), "The title may not be greater than 255 characters.", "Error message doesn't match");
    }
}
