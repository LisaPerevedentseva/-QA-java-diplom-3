package stellarBurgerPages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountPage extends HeaderElements {

    // текст-пояснение о возможности изменить персональные данные
    @FindBy (how = How.XPATH, using = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement explanatoryText;

   @Step ("Проверка отображения текста-пояснения о возможности изменить персональные данные в ЛК")
    public boolean isExplanatoryTextVisible(){
        explanatoryText.shouldBe(Condition.visible);
        return explanatoryText.isDisplayed();
    }

    // кнопка Выход
    @FindBy (how = How.XPATH, using =".//button[text()='Выход']")
    private SelenideElement exitButton;

    @Step ("Нажатие на кнопку \"Выход\" в ЛК")
    public SignInPage clickExitButton(){
        exitButton.click();
        return Selenide.page(SignInPage.class);
    }




}
