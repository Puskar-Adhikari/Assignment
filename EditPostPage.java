package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class EditPostPage {
    private AppiumDriver<MobileElement> driver;

    // Locators
    private By postMenuButton = By.xpath("//android.widget.Button[@content-desc='Options']");
    private By editOption = By.xpath("//android.widget.TextView[@text='Edit']");
    private By titleField = By.id("com.example.app:id/postTitle");
    private By bodyField = By.id("com.example.app:id/postBody");
    private By updateButton = By.id("com.example.app:id/updatePostSubmit");
    private By successMessage = By.id("com.example.app:id/successMessage");

    public EditPostPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void openPostMenu() {
        driver.findElement(postMenuButton).click();
    }

    public void selectEditOption() {
        driver.findElement(editOption).click();
    }

    public void updateTitle(String newTitle) {
        MobileElement title = driver.findElement(titleField);
        title.clear();
        title.sendKeys(newTitle);
    }

    public void updateBody(String newBody) {
        MobileElement body = driver.findElement(bodyField);
        body.clear();
        body.sendKeys(newBody);
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }
}
