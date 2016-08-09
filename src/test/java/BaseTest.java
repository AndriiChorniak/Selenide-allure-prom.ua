import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;

/**
 * Created by Andrii_Chorniak on 8/4/2016.
 */
public class BaseTest {

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
    }

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}
