package dto;

public class Project {

    String projectName;
    String projectCode;
    String projectDescription;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Project(String projectName, String projectCode, String projectDescription) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.projectDescription = projectDescription;
    }
}
