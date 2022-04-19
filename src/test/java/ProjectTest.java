import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTest {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "http://qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
    }

    @Test
    public void blabla() {
        open("login");
        $("#inputEmail").sendKeys("alex.fursa89@gmail.com");
        $("#inputPassword").sendKeys("FireFox_0889");
        $("#btnLogin").click();
        $("#createButton").shouldBe(Condition.visible);
    }
}
