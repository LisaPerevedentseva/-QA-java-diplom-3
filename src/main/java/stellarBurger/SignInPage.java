package stellarBurger;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class SignInPage {

    // поле ввода email
    @FindBy(how=How.XPATH, using=".//input[@name='name']")
    private SelenideElement fieldEmail;

    // заполнение поля email
    public SignInPage setFieldEmail(String email) {
        fieldEmail.setValue(email);
        return this;
    }

    // поле ввода пароля
    @FindBy(how=How.XPATH, using=".//input[@name='Пароль']")
    private SelenideElement fieldPassword;

    // заполнение поля Пароль
    public SignInPage setFieldPassword(String name) {
        fieldPassword.setValue(name);
        return this;
    }

    // ссылка "Зарегистрироваться"
    @FindBy(how=How.XPATH, using=".//a[text()='Зарегистрироваться']")
    private SelenideElement registrationLink;

    // нажатие на ссылку регистрации
    public RegistrationPage clickRegistrationLink(){
        registrationLink.click();
        return page(RegistrationPage.class);
    }

    // заголовок "Вход"
    @FindBy(how=How.XPATH, using=".//button[text()='Войти']")
    private SelenideElement enterButton;

    // проверка отображения кнопки Войти
    public boolean checkEnterButtonVisibility(){
        return enterButton.shouldBe(visible).isDisplayed();
    }

}
