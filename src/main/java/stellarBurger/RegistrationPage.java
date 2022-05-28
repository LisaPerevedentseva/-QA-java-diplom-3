package stellarBurger;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage extends HeaderElements {

    // поля Имя и email
    @FindBy(how= How.XPATH, using=".//input[@name='name']")
    private ElementsCollection nameAndEmailFields;

    // поле Пароль
    @FindBy(how= How.XPATH, using=".//input[@name='Пароль']")
    private SelenideElement passwordField;

    // кнопка Зарегистрироваться
    @FindBy(how= How.XPATH, using=".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    // нотификация Некорректный пароль
    @FindBy(how= How.XPATH, using=".//p[text()='Некорректный пароль']")
    private SelenideElement errorNotification;

    // метод проверки отображения нотификации Некорректный пароль
    public boolean checkVisibilityErrorNotification (){
        return errorNotification.isDisplayed();
    }

    // кнопка Войти
    @FindBy(how= How.XPATH, using=".//a[text()='Войти']")
    private SelenideElement loginLink;

    // нажатие на кнопку Войти
    public SignInPage clickLoginLink(){
        loginLink.click();
        return page(SignInPage.class);
    }

    // объединенный метод регистрации
    public void registration (String name, String email, String password){
        nameAndEmailFields.get(0).setValue(name);
        nameAndEmailFields.get(1).setValue(email);
        passwordField.setValue(password);
        registrationButton.click();
    }


}
