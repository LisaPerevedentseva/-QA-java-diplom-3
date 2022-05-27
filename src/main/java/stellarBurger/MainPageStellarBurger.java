package stellarBurger;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPageStellarBurger extends HeaderElements {

    public static final String MAIN_PAGE_URL="https://stellarburgers.nomoreparties.site";

    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement accountButton;

    // нажатие на кнопку Войти в аккаунт
    public SignInPage clickAccountButton(){
        accountButton.click();
        return page(SignInPage.class);
    }

    // кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;

    // нажатие на кнопку Оформить заказ
    public MainPageStellarBurger clickMakeOrderButton(){
        makeOrderButton.click();
        return page(MainPageStellarBurger.class);
    }

    // проверка отображения кнопки Оформить заказ
    public boolean checkMakeOrderButtonVisibility(){
        makeOrderButton.shouldBe(visible);
        return makeOrderButton.isDisplayed();
    }


}