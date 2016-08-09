import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Andrii_Chorniak on 8/9/2016.
 */
public class FailedTests extends BaseTest {

    @Stories("Failed")
    @Title("")
    @Test
    public void failed(){
        Assert.assertTrue(false);
    }
}
