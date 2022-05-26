package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {

    String label;

    public DropDown(String label) {
        this.label = label;
    }

    public void select(String option) {
        log.info("Choosing {} in {}", option, label);
        $(byXpath(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'col-xl-4')]//div[contains(@class, 'css-1hwfws3')]", label))).click();
        $(byText(option)).click();
    }
}