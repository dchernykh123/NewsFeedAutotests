import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeUserDataTest extends SetUp {
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();

    @Epic(value = "User page.")
    @Feature("Put account.")
    @Story("Change login.")
    @Description(value = "Change login.")
    @Test
    public void registrationTest() {
        methods.registration();
        headerElements.accountCircleButton.click();
        accountElements.changeData.click();
        accountElements.changeDataHeader.shouldBe(Condition.visible);
        accountElements.changeLoginInput.clear();
        accountElements.changeLoginInput.sendKeys(methods.generateRandomHexString(6));
        String newLoginText = accountElements.changeLoginInput.getAttribute("value");
        accountElements.changeDataButton.click();
        accountElements.changeDataHeader.should(Condition.disappear);
        Selenide.refresh();
        assertEquals(("Привет, " + newLoginText + "!"),  headerElements.helloHeader.getText());
        assertEquals(("Логин: " + newLoginText), accountElements.currentLogin.getText());
        methods.deleteUser();
    }
}
