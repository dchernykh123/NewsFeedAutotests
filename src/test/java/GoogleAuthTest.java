import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleAuthTest extends SetUp {
    private final LoginPage loginPage = new LoginPage();
    private final AccountElements accountElements = new AccountElements();
    private final HeaderElements headerElements = new HeaderElements();

    @Epic(value = "Login page.")
    @Feature("Login.")
    @Story("Google Login.")
    @Description(value = "Check google auth.")
    @Test
    public void loginTest() {
        open(loginPage.homePageURL);

        headerElements.enterButton.shouldBe(Condition.visible).click();
        loginPage.authTitle.shouldBe(Condition.visible);
        loginPage.googleAuthButton.shouldBe(Condition.visible).click();
        Selenide.switchTo().window(1);
        SelenideElement gmailInput = $(By.id("identifierId"));
        gmailInput.shouldBe(Condition.visible).sendKeys("newsClientTest@gmail.com");
        String emailText = gmailInput.getAttribute("value");
        gmailInput.sendKeys(Keys.ENTER);
        SelenideElement gmailPassword = $(By.cssSelector("input[type='password']"));
        gmailPassword.shouldBe(Condition.visible).sendKeys("QWEqwe123");
        gmailPassword.sendKeys(Keys.ENTER);
        Selenide.switchTo().window(0);
        headerElements.helloHeader.shouldBe(Condition.visible);
        assertEquals(("Привет, NewsClient!"), headerElements.helloHeader.getText());
        headerElements.accountCircleButton.click();
        accountElements.image.shouldBe(Condition.visible);
        String emailTextLow = emailText.toLowerCase(Locale.ROOT);
        assertEquals(("Емейл: " + emailTextLow), accountElements.currentEmail.getText());
    }
}
