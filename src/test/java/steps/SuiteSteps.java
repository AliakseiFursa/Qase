package steps;

import dto.Suite;
import io.qameta.allure.Step;
import pages.NewSuiteModal;
import pages.ProjectPage;

public class SuiteSteps {

    ProjectPage projectPage;
    NewSuiteModal newSuiteModal;

    public SuiteSteps() {
        projectPage = new ProjectPage();
        newSuiteModal = new NewSuiteModal();
    }

    @Step("Creation of suite")
    public void createSuite(Suite suite) {
        projectPage.clickNewSuiteButton();
        newSuiteModal.fillInSuiteInformation(suite);
        newSuiteModal.createSuite();
    }
}
