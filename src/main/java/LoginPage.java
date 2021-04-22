import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    String homePageURL = "https://news-feed.dunice-testing.com/";

    SelenideElement authTitle = $(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/form[1]/h1[1]"));
    SelenideElement regTitle = $(By.xpath("/html[1]/body[1]/app-root[1]/app-registration[1]/form[1]/h1[1]"));

    // login
    SelenideElement email = $(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/form[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
    SelenideElement password = $(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/form[1]/mat-form-field[2]/div[1]/div[1]/div[1]/input[1]"));
    SelenideElement submitButton = $(By.xpath("//body/app-root[1]/app-login[1]/form[1]/button[1]"));
    SelenideElement googleAuthButton = $(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/form[1]/button[2]"));
    // registration
    SelenideElement registrationButton = $(By.cssSelector("app-root:nth-child(1) app-login.ng-star-inserted:nth-child(3) form.login-form.ng-untouched.ng-pristine.ng-invalid a.mat-focus-indicator.mat-button.mat-button-base.mat-primary:nth-child(5) > span.mat-button-wrapper"));
    SelenideElement loginReg = $(By.xpath("/html[1]/body[1]/app-root[1]/app-registration[1]/form[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
    SelenideElement emailReg = $(By.xpath("/html[1]/body[1]/app-root[1]/app-registration[1]/form[1]/mat-form-field[2]/div[1]/div[1]/div[1]/input[1]"));
    SelenideElement passwordReg = $(By.xpath("/html[1]/body[1]/app-root[1]/app-registration[1]/form[1]/mat-form-field[3]/div[1]/div[1]/div[1]/input[1]"));
    SelenideElement submitRegButton = $(By.xpath("//body/app-root[1]/app-registration[1]/form[1]/button[1]"));



}
