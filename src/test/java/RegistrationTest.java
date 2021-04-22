import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegistrationTest extends SetUp {

    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();

    @Epic(value = "Login page.")
    @Feature("Registration.")
    @Story("Valid credential.")
    @Description(value = "Check registration with email and password.")
    @Test
    public void registrationTest() {
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

        // check account
        headerElements.accountCircleButton.click();
        accountElements.image.shouldBe(Condition.visible);
        assertEquals(("Логин: " + loginText), accountElements.currentLogin.getText());
        assertEquals(("Емейл: " + emailText), accountElements.currentEmail.getText());

        // delete user
        accountElements.deleteUser.click();
    }
}
