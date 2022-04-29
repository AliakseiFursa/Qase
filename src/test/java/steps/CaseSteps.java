package steps;

import dto.Case;
import io.qameta.allure.Step;
import pages.NewCasePage;
import pages.ProjectPage;

public class CaseSteps {

    NewCasePage newCasePage;
    ProjectPage projectPage;

    public CaseSteps() {
        newCasePage = new NewCasePage();
        projectPage = new ProjectPage();
    }

    @Step("Creation of case")
    public void createCase(Case newCase) {
        projectPage.clickNewCaseButton();
        newCasePage.fillInCaseInformation(newCase);
        newCasePage.createCase();
    }
}
