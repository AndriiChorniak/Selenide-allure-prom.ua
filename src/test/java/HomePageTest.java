import com.codeborne.selenide.WebDriverRunner;
import components.HeaderComponent;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Selenide.*;
import static core.Constants.HOME_PAGE_URL;
import static core.Constants.SELLER_PAGE_URL;
import static core.HelperCreator.getHomePageHelper;
import static helpers.HomePageHelper.Tabs;
import static pages.HomePage.SELL_LINK;
import static pages.HomePage.TITLE_BANNER;

/**
 * Created by Andrii_Chorniak on 8/1/2016.
 */
//@Listeners(TextReport.class)
public class HomePageTest extends BaseTest {

    @Stories("Home page")
    @Title("Verify LOGO")
    @Test
    public void verifyLogo() {
        open(HOME_PAGE_URL);
        $(HeaderComponent.LOGO).shouldBe(present);
    }

    @Stories("Home page")
    @Test
    public void verifyBanner() {
        String title = "Всеукраинский торговый центр в интернете";
        open(HOME_PAGE_URL);
        $(TITLE_BANNER).shouldHave(exactText(title));
        $(SELL_LINK).click();
        switchTo().window(1);
        Assert.assertTrue(WebDriverRunner.url().contains(SELLER_PAGE_URL));
    }

    @Stories("Home page")
    @Title("Verify categories of Consumer tab")
    @Test
    public void verifyCategoriesOfConsumerGoods() {
        open(HOME_PAGE_URL);
        getHomePageHelper().tabShouldBeActive("Потребительские товары");
        getHomePageHelper().verifyCategories(Tabs.CONSUMER_GOODS);
    }

    @Stories("Home page")
    @Title("Verify categories of Industrial tab")
    @Test
    public void verifyCategoriesOfIndustrialGoods() {
        open(HOME_PAGE_URL);
        $(HomePage.getTabs("Промышленные товары")).click();
        getHomePageHelper().verifyCategories(Tabs.INDUSTRIAL_GOODS);
    }

    @Stories("Home page")
    @Title("Verify categories of Services tab")
    @Test()
    public void verifyCategoriesOfServices() {
        open(HOME_PAGE_URL);
        $(HomePage.getTabs("Услуги")).click();
        getHomePageHelper().verifyCategories(Tabs.SERVICES);
    }

    @Stories("Home page")
    @Title("Failed test example")
    @Test
    public void failedTest() {
        Assert.assertTrue(false);
    }
}