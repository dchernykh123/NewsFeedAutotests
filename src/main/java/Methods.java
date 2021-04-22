import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Methods {

    private final LoginPage loginPage = new LoginPage();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();

    // random string generation
    public static String generateRandomHexString (int length){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < length){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }

    public void registration() {
        open(loginPage.homePageURL);
        headerElements.enterButton.shouldBe(Condition.visible).click();
        loginPage.authTitle.shouldBe(Condition.visible);
        loginPage.registrationButton.shouldBe(Condition.visible).click();
        loginPage.regTitle.shouldBe(Condition.visible);
        loginPage.loginReg.sendKeys(generateRandomHexString(5));
        String loginText = loginPage.loginReg.getAttribute("value");
        loginPage.emailReg.sendKeys(generateRandomHexString(5) + "@gmail.com");
        loginPage.passwordReg.sendKeys(generateRandomHexString(6));
        loginPage.submitRegButton.click();
        headerElements.helloHeader.shouldBe(Condition.visible);
        assertEquals(("Привет, " + loginText + "!"), headerElements.helloHeader.getText());
    }

    public void deleteUser() {
        headerElements.accountCircleButton.shouldBe(Condition.visible).click();
        accountElements.deleteUser.shouldBe(Condition.visible).click();
    }
}
