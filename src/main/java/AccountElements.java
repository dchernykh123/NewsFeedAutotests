import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountElements {

    SelenideElement image = $(By.xpath("//body/app-root[1]/app-user[1]/div[1]/div[1]/img[1]"));
    SelenideElement currentLogin = $(By.xpath("/html[1]/body[1]/app-root[1]/app-user[1]/div[1]/div[1]/div[1]/h1[1]"));
    SelenideElement currentEmail = $(By.xpath("/html[1]/body[1]/app-root[1]/app-user[1]/div[1]/div[1]/div[1]/h1[2]"));
    SelenideElement changeData = $(By.xpath("//body/app-root[1]/app-user[1]/div[1]/div[1]/div[2]/button[1]"));
        SelenideElement changeDataHeader = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-edit-user[1]/h1[1]"));
        SelenideElement changeLoginInput = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-edit-user[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]"));
        SelenideElement changeDataButton = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-edit-user[1]/div[2]/button[1]"));
    SelenideElement addNews = $(By.xpath("//body/app-root[1]/app-user[1]/div[1]/div[1]/div[2]/button[2]"));
        SelenideElement addNewPostHeader = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/h1[1]"));
        SelenideElement newPostName = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]"));
        SelenideElement newPostDescription = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/div[1]/mat-form-field[2]/div[1]/div[1]/div[3]/textarea[1]"));
        SelenideElement newPostTags = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/div[1]/mat-form-field[3]/div[1]/div[1]/div[3]/input[1]"));
        SelenideElement newPostImg = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/input[1]"));
        SelenideElement newPostSubmitButton = $(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/app-add-news[1]/form[1]/div[2]/button[1]"));
    SelenideElement deleteUser = $(By.xpath("//body/app-root[1]/app-user[1]/div[1]/div[1]/div[2]/button[3]"));
}
