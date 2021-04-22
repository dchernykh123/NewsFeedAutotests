import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginAndRegInputErrorsTest extends SetUp {

    LoginPage loginPage = new LoginPage();
    Methods methods = new Methods();
    HeaderElements headerElements = new HeaderElements();

    @Epic(value = "Login page.")
    @Feature("Login and Registration.")
    @Story("Errors notifications.")
    @Description(value = "Check errors notifications is visible.")
    @Test()
    public void inputErrorsTest() {
        open(loginPage.homePageURL);

        // Login page
        // Incorrect email, correct password
        headerElements.enterButton.shouldBe(Condition.visible).click();
        loginPage.email.sendKeys(methods.generateRandomHexString(5));
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.email.sendKeys(methods.generateRandomHexString(5) + "@");
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.email.sendKeys(methods.generateRandomHexString(5) + "@gmail");
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.email.sendKeys(methods.generateRandomHexString(5) + "@gmail.");
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.email.sendKeys(methods.generateRandomHexString(5) + ".com");
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.email.sendKeys(methods.generateRandomHexString(5) + "@.com");
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.email.sendKeys("@gmail.com");
        loginPage.password.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        // Correct email, incorrect password
        loginPage.email.sendKeys(methods.generateRandomHexString(5) + "@gmail.com");
        loginPage.password.sendKeys(methods.generateRandomHexString(5));
        loginPage.submitButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();

        // Registration page
        // Incorrect login, correct email, correct password
        loginPage.registrationButton.click();
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@gmail.com");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        // Correct login, incorrect email, correct password
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@gmail");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@gmail.");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + ".com");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@.com");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys("@gmail.com");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(6));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
        // Correct login, correct email, incorrect password
        loginPage.loginReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.emailReg.sendKeys(methods.generateRandomHexString(5) + "@gmail.com");
        loginPage.passwordReg.sendKeys(methods.generateRandomHexString(5));
        loginPage.submitRegButton.click();
        $(By.tagName("mat-error")).shouldBe(Condition.visible);
        Selenide.refresh();
    }
}
