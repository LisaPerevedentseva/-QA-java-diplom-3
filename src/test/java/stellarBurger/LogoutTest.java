package stellarBurger;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    AccountPage accountPage = page (AccountPage.class);
    String email = "lisaperev@yandex.ru";
    String password = "461810";

    @BeforeClass
    public static void setProperties() {
        Configuration.browser = "edge";
    }

    // авторизация перед тестом
    @Before
    public void authorizationBeforeTest(){
        mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .clickAccountButtonInHeader();
    }

    @Description("Проверка логаута")
    @Test
    public void logoutTest(){
       Assert.assertTrue(accountPage.clickExitButton()
               .checkEnterButtonVisibility());
    }

}
