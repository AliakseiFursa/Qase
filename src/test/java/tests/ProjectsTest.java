package tests;

import dto.Project;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest{

    @Test(description = "Creation of new project test")
    public void createNewProject() {
        Project project = new Project("GoodDay", "GD21", "Very interesting project");
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login("alex.fursa89@gmail.com", "FireFox_0889");
        projectsPage.isPageOpened();
        projectsPage.clickNewProjectButton();
        newProjectPage.isPageOpened();
        newProjectPage.inputProjectInfo(project);
        newProjectPage.choosePublicAccessType();
        newProjectPage.createProject();
        projectPage.isPageOpened();
        assertEquals(projectPage.getProjectName(), project.getProjectName(), "Project name doesn't match");
    }
}
