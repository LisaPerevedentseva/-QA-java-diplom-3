package stellarBurger;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);

    @BeforeClass
    public static void setProperties() {
        Configuration.browser = "edge";
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @Description("Проверка перехода в таб \"Булки\"")
    @Test
    public void openBunsTabTest (){
        Assert.assertTrue("Раздел \"Булки\" не выбран", mainPage.clickSauceButton()
                .clickBunsButton()
                .checkVisibilityBunText());
    }

    @Description("Проверка перехода в таб \"Соусы\"")
    @Test
    public void openSauceTabTest (){
        Assert.assertTrue("Раздел \"Соусы\" не выбран", mainPage.clickSauceButton()
                .checkVisibilitySauceText());
    }

    @Description("Проверка перехода в таб \"Начинки\"")
    @Test
    public void openFillingsTabTest (){
        Assert.assertTrue("Раздел \"Начинки\" не выбран", mainPage.clickFillingsButton()
                .checkVisibilityFillingsText());
    }

}
