package stellarBurger;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);

    @BeforeClass
    public static void setProperties() {
        Configuration.browser = "edge";
    }

    @Test
    public void successRegistrationTest(){
         Assert.assertTrue("Ошибка регистрации", mainPage.clickAccountButton()
                .clickRegistrationLink()
                .setName("Лиза")
                .setEmail("jkl@k789m44.ru")
                .setPassword("1234567")
                .clickRegistrationButton()
                .checkEnterButtonVisibility());

    }

}
