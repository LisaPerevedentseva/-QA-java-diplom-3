package stellarBurgerTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import stellarBurgerPages.MainPageStellarBurger;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    String email = "lisaperev@yandex.ru";
    String password = "461810";


    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @DisplayName("Логин через кнопку в хедере")
    @Test
    public void successLoginWithButtonInHeader (){
        Assert.assertTrue("Авторизация через кнопку в хедере не выполнена", mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на главной странице")
    @Test
    public void successLoginWithAccountButtonOnMainPage (){
        Assert.assertTrue("Авторизация через кнопку на главной не выполнена", mainPage.clickAccountButton()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на странице регистрации")
    @Test
    public void successLoginWithButtonOnRegistrationPage (){
        Assert.assertTrue("Авторизация через страницу регистрации не выполнена", mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .clickLoginLink()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

    @DisplayName("Логин через кнопку на странице восстановления пароля")
    @Test
    public void successLoginWithButtonOnRecoveryPage (){
        Assert.assertTrue("Авторизация через страницу восстановления пароля не выполнена", mainPage.clickAccountButtonInHeader()
                .clickPasswordRecoveryLink()
                .clickEnterButtonOnRecoveryPage()
                .authorization(email, password)
                .isMakeOrderButtonVisible());
    }

}
