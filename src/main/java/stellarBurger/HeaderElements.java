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


}
