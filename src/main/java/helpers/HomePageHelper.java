package helpers;

import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Andrii_Chorniak on 8/5/2016.
 */
public class HomePageHelper {

    public void tabShouldBeActive(String tabName) {
        Assert.assertTrue($(HomePage.getTabs(tabName)).getAttribute("class").contains("active"));
    }

    public void verifyCategories(Tabs tab) {
        ElementsCollection elementsCollections = $$(HomePage.CATEGORIES_LIST);

        if (tab.equals(Tabs.CONSUMER_GOODS)) {
            elementsCollections.shouldHaveSize(20);
            Assert.assertEquals(elementsCollections.getTexts(), Tabs.CONSUMER_GOODS.getCategories());
        } else if (tab.equals(Tabs.INDUSTRIAL_GOODS)) {
            elementsCollections.shouldHaveSize(17);
            Assert.assertEquals(elementsCollections.getTexts(), Tabs.INDUSTRIAL_GOODS.getCategories());
        } else if (tab.equals(Tabs.SERVICES)) {
            elementsCollections.shouldHaveSize(18);
            Assert.assertEquals(elementsCollections.getTexts(), Tabs.SERVICES.getCategories());
        }
    }

    public enum Tabs {
        INDUSTRIAL_GOODS("Отопление", "Строительство", "Промышленное оборудование, станки", "Оборудование и товары " +
                "для предоставления услуг", "Электрооборудование", "Инструмент", "Сельхозпродукция и техника",
                "Металл, пластик, резина", "Безопасность и защита", "Грузовики, автобусы, спецтехника",
                "Контрольно-измерительные приборы", "Сырье и материалы", "Медицина", "Тара и упаковка", "Промышленная" +
                " химия", "Авиа-, ж/д-, водный транспорт", "Все промышленные товары >"),
        CONSUMER_GOODS("Все для отпуска", "Все для пляжа", "Купуй українське", "Одежда, обувь, аксессуары",
                "Украшения и часы", "Авто-, мото", "Техника и электроника", "Мобильные телефоны, смартфоны", "Товары " +
                "для детей", "Спорт и отдых", "Товары для дома", "Мебель и фурнитура", "Строительство", "Товары для " +
                "сада", "Красота и здоровье", "Подарки, хобби, книги", "Зоотовары", "Свадебные товары", "Военторг",
                "Все потребительские товары >"),
        SERVICES("Инженерно-строительные услуги", "Ремонт и обслуживание техники", "Деловые услуги", "Бытовые " +
                "услуги", "Услуги проката и аренды",
                "Промышленные услуги", "Услуги досуга, отдыха, культуры", "Полиграфия и дизайн", "Логистические и " +
                "складские услуги", "Медицина, красота и здоровье", "Образование и тренинги", "Реклама, маркетинг, " +
                "PR", "Недвижимость, риэлторские услуги", "Охранные и аварийные службы", "Услуги в сфере IT",
                "Страхование", "Коммунальные услуги", "Все услуги >");

        private String[] categories;

        Tabs(String... categ) {
            categories = categ;
        }

        public String[] getCategories() {
            return categories;
        }
    }
}
