package stellarBurger;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPageStellarBurger {

    public static final String MAIN_PAGE_URL="https://stellarburgers.nomoreparties.site";

    // кнопка "Личный кабиент" и методы взаимодействия
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement accountButton;

    // нажатие на кнопку "Личный кабинет"
    public SignInPage clickAccountButton (){
        accountButton.click();
        return page(SignInPage.class);
    }

    // проверка отображения кнопки
    public Boolean checkVisibilityAccountButton () {
        return accountButton.isDisplayed();
    }
}