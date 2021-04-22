import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends SetUp {

    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();

    @Epic(value = "Login page.")
    @Feature("Login.")
    @Story("Valid Login.")
    @Description(value = "Check sign in with email and password.")
    @Test
    public void loginTest() {
        open(loginPage.homePageURL);

        // registration
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

        // login
        headerElements.quitButton.click();
        headerElements.enterButton.shouldBe(Condition.visible).click();
        loginPage.authTitle.shouldBe(Condition.visible);
        loginPage.email.sendKeys(emailText);
        loginPage.password.sendKeys(passwordText);
        loginPage.submitButton.click();
        assertEquals(("Привет, " + loginText + "!"), headerElements.helloHeader.getText());

        // delete user
        methods.deleteUser();
    }
}
