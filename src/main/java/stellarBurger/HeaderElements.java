package stellarBurger;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HeaderElements {

    // кнопка "Личный кабиент"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement accountButtonInHeader;

    @Step ("Нажатие на кнопку \"Личный кабинет\" в хедере страницы")
    public SignInPage clickAccountButtonInHeader (){
        accountButtonInHeader.click();
        return page(SignInPage.class);
    }

   @Step ("Проверка отображения кнопки \"Личный кабинет\" в хедере страницы")
    public Boolean checkVisibilityAccountButton () {
        return accountButtonInHeader.isDisplayed();
    }

    // логотип Stellar Burger
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerLogo;

    @Step ("Нажатие на логотип Stellar Burger")
    public MainPageStellarBurger clickStellarBurgerLogo (){
        stellarBurgerLogo.shouldBe(Condition.visible);
        stellarBurgerLogo.click();
        return page(MainPageStellarBurger.class);
    }

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @Step ("Нажатие на кнопку \"Конструктор\"")
    public MainPageStellarBurger clickConstructorButton (){
        constructorButton.click();
        return page(MainPageStellarBurger.class);
    }


}
