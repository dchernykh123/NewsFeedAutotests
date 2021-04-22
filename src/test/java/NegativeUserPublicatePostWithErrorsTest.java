import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NegativeUserPublicatePostWithErrorsTest extends SetUp {

    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountElements accountElements = new AccountElements();

    @Epic(value = "User page.")
    @Feature("Create new post.")
    @Story("Negative test to create new post.")
    @Description(value = "Negative test to create new post and check error notification.")
    @Test
    public void deleteUserTest() {
        methods.registration();
        headerElements.accountCircleButton.shouldBe(Condition.visible).click();
        // null
        accountElements.addNews.shouldBe(Condition.visible).click();
        accountElements.addNewPostHeader.shouldBe(Condition.visible);
        accountElements.newPostSubmitButton.click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/p[1]")).shouldBe(Condition.visible);
        Selenide.refresh();
        // null title
        accountElements.addNews.shouldBe(Condition.visible).click();
        accountElements.addNewPostHeader.shouldBe(Condition.visible);
        accountElements.newPostDescription.sendKeys(methods.generateRandomHexString(10));
        accountElements.newPostTags.sendKeys(methods.generateRandomHexString(10) + " " + methods.generateRandomHexString(10));
        accountElements.newPostImg.sendKeys("/Users/dunice/Desktop/NewsFeedAutotests/src/main/resources/maxresdefault.jpg");
        accountElements.newPostSubmitButton.click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/p[1]")).shouldBe(Condition.visible);
        Selenide.refresh();
        // null description
        accountElements.addNews.shouldBe(Condition.visible).click();
        accountElements.addNewPostHeader.shouldBe(Condition.visible);
        accountElements.newPostName.sendKeys(methods.generateRandomHexString(10));
        accountElements.newPostTags.sendKeys(methods.generateRandomHexString(10) + " " + methods.generateRandomHexString(10));
        accountElements.newPostImg.sendKeys("/Users/dunice/Desktop/NewsFeedAutotests/src/main/resources/maxresdefault.jpg");
        accountElements.newPostSubmitButton.click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/p[1]")).shouldBe(Condition.visible);
        Selenide.refresh();
        //null tags
        accountElements.addNews.shouldBe(Condition.visible).click();
        accountElements.addNewPostHeader.shouldBe(Condition.visible);
        accountElements.newPostName.sendKeys(methods.generateRandomHexString(10));
        accountElements.newPostDescription.sendKeys(methods.generateRandomHexString(10));
        accountElements.newPostImg.sendKeys("/Users/dunice/Desktop/NewsFeedAutotests/src/main/resources/maxresdefault.jpg");
        accountElements.newPostSubmitButton.click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/p[1]")).shouldBe(Condition.visible);
        Selenide.refresh();
        // null img
        accountElements.addNews.shouldBe(Condition.visible).click();
        accountElements.addNewPostHeader.shouldBe(Condition.visible);
        accountElements.newPostName.sendKeys(methods.generateRandomHexString(10));
        accountElements.newPostDescription.sendKeys(methods.generateRandomHexString(10));
        accountElements.newPostTags.sendKeys(methods.generateRandomHexString(10) + " " + methods.generateRandomHexString(10));
        accountElements.newPostSubmitButton.click();
        $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/p[1]")).shouldBe(Condition.visible);
        Selenide.refresh();

        methods.deleteUser();
    }
}
