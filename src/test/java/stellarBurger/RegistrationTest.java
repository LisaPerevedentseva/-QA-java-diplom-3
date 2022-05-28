package stellarBurger;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


public class RegistrationTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    SignInPage signInPage = page(SignInPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);

    @BeforeClass
    public static void setProperties() {
        Configuration.browser = "edge";
    }

    String name = RandomStringUtils.randomAlphabetic(8);
    String email = RandomStringUtils.randomAlphabetic(3) + "@yandex.ru";
    String correctPassword = RandomStringUtils.randomAlphanumeric(6);
    String incorrectPassword = RandomStringUtils.randomAlphanumeric(5);

    @DisplayName("Регистрация с корректным паролем")
    @Test
    public void registrationWithCorrectPasswordSuccessTest (){
        mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .registration(name, email, correctPassword);
        Assert.assertTrue(signInPage.checkEnterButtonVisibility());
    }

    @DisplayName("Регистрация с коротким паролем меньше 6 символов")
    @Test
    public void registrationWithInCorrectPasswordFailedTest (){
        mainPage.clickAccountButtonInHeader()
                .clickRegistrationLink()
                .registration(name, email, incorrectPassword);
        Assert.assertTrue(registrationPage.checkVisibilityErrorNotification());
    }
}
