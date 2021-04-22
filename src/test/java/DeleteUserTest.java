import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUserTest extends SetUp {
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();
    private final LoginPage loginPage = new LoginPage();

    @Epic(value = "User page.")
    @Feature("Delete account.")
    @Story("Delete user.")
    @Description(value = "Delete user.")
    @Test
    public void deleteUserTest() {
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

        // delete user and assert that
        headerElements.accountCircleButton.click();
        accountElements.deleteUser.shouldBe(Condition.visible).click();
        headerElements.accountCircleButton.should(Condition.disappear);
        headerElements.enterButton.shouldBe(Condition.visible).click();
        loginPage.authTitle.shouldBe(Condition.visible);
        loginPage.email.sendKeys(emailText);
        loginPage.password.sendKeys(passwordText);
        headerElements.helloHeader.shouldNotBe(Condition.visible);
    }
}
