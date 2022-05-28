package stellarBurger;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class SignInPage extends HeaderElements {

    // поле ввода email
    @FindBy(how=How.XPATH, using=".//input[@name='name']")
    private SelenideElement fieldEmail;

    // поле ввода пароля
    @FindBy(how=How.XPATH, using=".//input[@name='Пароль']")
    private SelenideElement fieldPassword;


    // ссылка "Зарегистрироваться"
    @FindBy(how=How.XPATH, using=".//a[text()='Зарегистрироваться']")
    private SelenideElement registrationLink;

    // нажатие на ссылку регистрации
    public RegistrationPage clickRegistrationLink(){
        registrationLink.click();
        return page(RegistrationPage.class);
    }

    // ссылка "Восстановить пароль"
    @FindBy(how=How.XPATH, using=".//a[text()='Восстановить пароль']")
    private SelenideElement passwordRecoveryLink;

    // нажатие на кнопку восстановления пароля
    public PasswordRecoveryPage clickPasswordRecoveryLink(){
        passwordRecoveryLink.click();
        return page(PasswordRecoveryPage.class);
    }

    // кнопка Войти
    @FindBy(how=How.XPATH, using=".//button[text()='Войти']")
    private SelenideElement enterButton;

    // проверка отображения кнопки Войти
    public boolean checkEnterButtonVisibility(){
        return enterButton.shouldBe(visible).isDisplayed();
    }

    // объединенный метод авторизации
    public MainPageStellarBurger authorization (String email, String password){
        fieldEmail.setValue(email);
        fieldPassword.setValue(password);
        enterButton.click();
        return page(MainPageStellarBurger.class);
    }


}
