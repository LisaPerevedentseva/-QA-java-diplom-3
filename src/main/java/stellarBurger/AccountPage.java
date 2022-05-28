package stellarBurger;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountPage extends HeaderElements {

    // текст-пояснение о возможности изменить персональные данные
    @FindBy (how = How.XPATH, using = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement explanatoryText;

    // проверка отображения поясняющего текста
    public boolean checkVisibilityExplanatoryText(){
        explanatoryText.shouldBe(Condition.visible);
        return explanatoryText.isDisplayed();
    }

    // кнопка Выход
    @FindBy (how = How.XPATH, using =".//button[text()='Выход']")
    private SelenideElement exitButton;

    // нажатие на кнопку Выход
    public SignInPage clickExitButton(){
        exitButton.click();
        return page(SignInPage.class);
    }




}
