package components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Andrii_Chorniak on 8/4/2016.
 */
public class HeaderComponent {
    public static final By LOGO = By.xpath("//div[contains(@class,'logo')]//a[@href='http://prom.ua/']");

    public static void goToHomePage(){
        $(LOGO).click();
    }
}
