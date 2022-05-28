package stellarBurger;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HeaderElements {

    // кнопка "Личный кабиент"
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement accountButtonInHeader;

    // нажатие на кнопку "Личный кабинет"
    public SignInPage clickAccountButtonInHeader (){
        accountButtonInHeader.click();
        return page(SignInPage.class);
    }

    // проверка отображения кнопки
    public Boolean checkVisibilityAccountButton () {
        return accountButtonInHeader.isDisplayed();
    }

    // логотип Stellar Burger
    @FindBy(how = How.XPATH, using = ".//svg[@xmlns='http://www.w3.org/2000/svg']")
    private SelenideElement stellarBurgerLogo;

    // нажатие на логотип Stellar Burger
    public MainPageStellarBurger clickStellarBurgerLogo (){
        stellarBurgerLogo.click();
        return page(MainPageStellarBurger.class);
    }

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    // нажатие на кнопку Конструктор
    public MainPageStellarBurger clickConstructorButton (){
        constructorButton.click();
        return page(MainPageStellarBurger.class);
    }


}
