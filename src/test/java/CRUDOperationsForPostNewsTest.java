import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.io.File;

public class CRUDOperationsForPostNewsTest extends SetUp {

    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();
    private final LoginPage loginPage = new LoginPage();

    @Epic(value = "User page.")
    @Feature("CRUD new post.")
    @Story("Positive test to CRUD new post.")
    @Description(value = "Positive test to CRUD new post and assert that.")
    @Test
    public void deleteUserTest() {
        methods.registration();
        headerElements.accountCircleButton.shouldBe(Condition.visible).click();
        accountElements.addNews.shouldBe(Condition.visible).click();
        accountElements.addNewPostHeader.shouldBe(Condition.visible);
        accountElements.newPostName.sendKeys(methods.generateRandomHexString(10));
        String newPostNameText = accountElements.newPostName.getAttribute("value");
        accountElements.newPostDescription.sendKeys(methods.generateRandomHexString(10));
        String newPostDescriptionText = accountElements.newPostName.getAttribute("value");
        accountElements.newPostTags.sendKeys(methods.generateRandomHexString(10) + " " + methods.generateRandomHexString(10));
        String newPostTagsText = accountElements.newPostName.getAttribute("value");
        // make relative path to file
        String path = "src/main/resources/maxresdefault.jpg";
        File file = new File(new File(path).getAbsolutePath());
        //
        accountElements.newPostImg.sendKeys(file.getAbsolutePath());
        accountElements.newPostSubmitButton.click();
        accountElements.addNewPostHeader.should(Condition.disappear);
        // сделать assert что новый пост добавлен на странице аккаунта и на главной

        methods.deleteUser();
    }
}
