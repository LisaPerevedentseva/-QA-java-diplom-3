package stellarBurger;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    String email = "lisaperev@yandex.ru";
    String password = "461810";

    @BeforeClass
    public static void setProperties() {
        Configuration.browser = "edge";
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @DisplayName("Логин через кнопку в хедере")
    @Test
    public void successLoginWithButtonInHeader (){
        Assert.assertTrue(mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

    @DisplayName("Логин через кнопку на главной странице")
    @Test
    public void successLoginWithAccountButtonOnMainPage (){
        Assert.assertTrue(mainPage.clickAccountButton()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

    @DisplayName("Логин через кнопку на странице регистрации")
    @Test
    public void successLoginWithButtonOnRegistrationPage (){
        Assert.assertTrue(mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .clickLoginLink()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

    @DisplayName("Логин через кнопку на странице восстановления пароля")
    @Test
    public void successLoginWithButtonOnRecoveryPage (){
        Assert.assertTrue(mainPage.clickAccountButtonInHeader()
                .clickPasswordRecoveryLink()
                .clickEnterButtonOnRecoveryPage()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

}
