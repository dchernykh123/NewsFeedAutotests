import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElements {
    SelenideElement enterButton = $(By.cssSelector("body:nth-child(2) app-root:nth-child(1) mat-toolbar.mat-toolbar.top-panel.mat-primary.mat-toolbar-single-row:nth-child(1) > button.mat-focus-indicator.mat-raised-button.mat-button-base.mat-accent"));
    SelenideElement homeButton = $(By.xpath("//body/app-root[1]/mat-toolbar[1]/div[1]/button[1]"));
    SelenideElement accountCircleButton = $(By.xpath("//body/app-root[1]/mat-toolbar[1]/div[1]/button[2]"));
    SelenideElement quitButton = $(By.xpath("//body/app-root[1]/mat-toolbar[1]/button[1]"));

    SelenideElement helloHeader = $(By.xpath("/html/body/app-root/mat-toolbar/p"));

}
