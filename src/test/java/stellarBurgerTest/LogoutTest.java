package stellarBurgerTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stellarBurgerPages.AccountPage;
import stellarBurgerPages.MainPageStellarBurger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogoutTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    AccountPage accountPage = page(AccountPage.class);
    String email = "lisaperev@yandex.ru";
    String password = "461810";

    // авторизация перед тестом
    @Before
    public void authorizationBeforeTest() {
        mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .clickAccountButtonInHeader();
    }

    @DisplayName("Проверка логаута")
    @Test
    public void logoutTest() {
        Assert.assertTrue("Ошибка логаута", accountPage.clickExitButton()
                .isEnterButtonVisible());
    }

}
