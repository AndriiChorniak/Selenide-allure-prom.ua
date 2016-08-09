package pages;

import org.openqa.selenium.By;

/**
 * Created by Andrii_Chorniak on 8/3/2016.
 */
public class HomePage {
    public static final By TITLE_BANNER = By.xpath("//div[@class='b-page']/h1");
    public static final By SELL_LINK = By.xpath("//a[contains(@data-subscribe,'cabinet')]");
    public static final By BUY_LINK = By.xpath("//a[contains(@data-subscribe,'scrollTo')]");
    public static final By CATEGORIES_LIST = By.xpath("//li[@style='display: list-item;']//li[@class='b-categories-list__item']");

    private static final String TABS = "//span[normalize-space(text())='%s']/..";

    public static final By getTabs(String tabName){
        return By.xpath(String.format(TABS,tabName));
    }
}
