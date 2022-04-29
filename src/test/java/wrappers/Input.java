package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {

    String label;

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing '{}' into {}", text, label);
        $(byXpath(String.format("//label[text()='%s']/..//p[contains(@class,'empty-node')]", label))).sendKeys(text);
    }
}
