package steps;

import dto.Project;
import io.qameta.allure.Step;
import pages.NewProjectPage;
import pages.ProjectPage;
import pages.ProjectsPage;

public class ProjectSteps {

    NewProjectPage newProjectPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;

    public ProjectSteps() {
        newProjectPage = new NewProjectPage();
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();
    }

    @Step("Creation of project")
    public void createProject(Project project) {
        projectsPage.clickNewProjectButton();
        newProjectPage.isPageOpened();
        newProjectPage.inputProjectInfo(project);
        newProjectPage.setAccessType(project);
        newProjectPage.createProject();
    }
}
