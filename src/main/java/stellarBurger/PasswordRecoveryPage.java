package stellarBurger;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoveryPage extends HeaderElements {

    // ссылка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterButtonOnRecoveryPage;

    // нажатие на кнопку Войти
    public SignInPage clickEnterButtonOnRecoveryPage(){
        enterButtonOnRecoveryPage.click();
        return page(SignInPage.class);
    }

}
