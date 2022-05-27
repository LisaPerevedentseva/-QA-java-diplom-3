package stellarBurger;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
    public void exit(){
        Selenide.closeWebDriver();
    }

    @Test
    public void successLoginWithButtonInHeader (){
        Assert.assertTrue(mainPage.clickAccountButtonInHeader()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

    @Test
    public void successLoginWithAccountButtonOnMainPage (){
        Assert.assertTrue(mainPage.clickAccountButton()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

    @Test
    public void successLoginWithButtonOnRegistrationPage (){
        Assert.assertTrue(mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .clickEnterLink()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }

    @Test
    public void successLoginWithButtonOnRecoveryPage (){
        Assert.assertTrue(mainPage.clickAccountButtonInHeader()
                .clickPasswordRecoveryLink()
                .clickEnterButtonOnRecoveryPage()
                .authorization(email, password)
                .checkMakeOrderButtonVisibility());
    }




}
