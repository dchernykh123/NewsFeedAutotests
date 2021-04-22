import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeChangeUserDataTest extends SetUp {

    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();
    private final LoginPage loginPage = new LoginPage();

    @Epic(value = "User page.")
    @Feature("Put account.")
    @Story("Negative change login.")
    @Description(value = "Negative test to change login.")
    @Test
    public void registrationTest() {
        // registration
        open(loginPage.homePageURL);
        headerElements.enterButton.shouldBe(Condition.visible).click();
        loginPage.authTitle.shouldBe(Condition.visible);
        loginPage.registrationButton.shouldBe(Condition.visible).click();
        loginPage.regTitle.shouldBe(Condition.visible);
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        String loginText = loginPage.loginReg.getAttribute("value");
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@gmail.com");
        String emailText = loginPage.emailReg.getAttribute("value");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        String passwordText = loginPage.passwordReg.getAttribute("value");
        loginPage.submitRegButton.click();
        headerElements.helloHeader.shouldBe(Condition.visible);
        assertEquals(("Привет, " + loginText + "!"), headerElements.helloHeader.getText());
        // change login
        headerElements.accountCircleButton.click();
        accountElements.changeData.click();
        accountElements.changeDataHeader.shouldBe(Condition.visible);
        accountElements.changeLoginInput.clear();
        accountElements.changeDataButton.click();
        Selenide.refresh();
        assertEquals(("Привет, " + loginText + "!"),  headerElements.helloHeader.getText());
        assertEquals(("Логин: " + loginText), accountElements.currentLogin.getText());
        methods.deleteUser();
    }
}
