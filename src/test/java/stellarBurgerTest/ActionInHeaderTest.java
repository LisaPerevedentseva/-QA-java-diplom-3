package stellarBurgerTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import stellarBurgerPages.AccountPage;
import stellarBurgerPages.MainPageStellarBurger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ActionInHeaderTest {

    MainPageStellarBurger mainPage = open(MainPageStellarBurger.MAIN_PAGE_URL, MainPageStellarBurger.class);
    AccountPage accountPage = page (AccountPage.class);
    String email = "lisaperev@yandex.ru";
    String password = "461810";


    // авторизация перед каждым тестом
    @Before
    public void authorizationBeforeTest(){
        mainPage.clickAccountButtonInHeader()
                .authorization(email, password);
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    @DisplayName ("Проверка перехода в личный кабинет после авторизации по кнопке в хедере")
    @Test
    public void openAccountPageTest(){
        mainPage.clickAccountButtonInHeader();
        Assert.assertTrue("Переход в личный кабинет не выполнен", accountPage.isExplanatoryTextVisible());
    }

    @DisplayName ("Проверка возвращения на главную страницу из личного кабинета по Лого")
    @Test
    public void returnToMainPageByLogoTest(){
        mainPage.clickAccountButtonInHeader();
        Assert.assertTrue("Ошибка открытия конструктора", accountPage.clickStellarBurgerLogo()
                .isMakeOrderButtonVisible());

    }

    @DisplayName("Проверка перехода в конструктор из личного кабинета")
    @Test
    public void openConstructorTest(){
        mainPage.clickAccountButtonInHeader();
        Assert.assertTrue("Ошибка открытия конструктора", accountPage.clickConstructorButton()
                .isMakeOrderButtonVisible());
    }


}
