package tests;

import api.ProjectApiClient;
import dto.Project;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectApiTest extends BaseTest {

    @Test
    public void status200() {
        Project project = Project
                .builder()
                .code("234234")
                .name("APITEST")
                .description("NHVBFSUNV")
                .accessType("all")
                .build();
        projectApiClient.createNewProject(project);
        Project actual = projectApiClient.getProjectByCode(project.getCode());
        assertEquals(actual.getName(), project.getName());
        assertEquals(actual.getCode(), project.getCode());
    }

    @Test
    public void accessGroup() {
        System.out.println(new ProjectApiClient().getProjectByCode("234234"));
    }
}
