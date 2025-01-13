package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class DeletePostPage {
    private AppiumDriver<MobileElement> driver;

    // Locators
    private By postMenuButton = By.xpath("//android.widget.Button[@content-desc='Options']");
    private By deleteOption = By.xpath("//android.widget.TextView[@text='Delete']");
    private By postContent = By.xpath("//android.widget.TextView[@text='Test Title']");

    public DeletePostPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void openPostMenu() {
        driver.findElement(postMenuButton).click();
    }

    public void selectDeleteOption() {
        driver.findElement(deleteOption).click();
    }

    public boolean isPostDeleted() {
        return driver.findElements(postContent).isEmpty();
    }
}
