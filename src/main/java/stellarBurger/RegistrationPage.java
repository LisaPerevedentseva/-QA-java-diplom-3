package stellarBurger;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    @FindBy(how= How.XPATH, using=".//input[@name='name']")
    private ElementsCollection nameAndEmailFields;

    // метод заполнения поля Имя
    public RegistrationPage setName (String name){
        nameAndEmailFields.get(0).setValue(name);
        return this;
    }

    // метод заполнения поля email
    public RegistrationPage setEmail (String email){
        nameAndEmailFields.get(1).setValue(email);
        return this;
    }

    // поле Пароль
    @FindBy(how= How.XPATH, using=".//input[@name='Пароль']")
    private SelenideElement passwordField;

    public RegistrationPage setPassword (String password){
        passwordField.setValue(password);
        return this;
    }

    // кнопка Зарегистрироваться
    @FindBy(how= How.XPATH, using=".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    public SignInPage clickRegistrationButton (){
        registrationButton.click();
        return page(SignInPage.class);
    }

}
