package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AddPostPage {
    private AppiumDriver<MobileElement> driver;

    // Locators
    private By addButton = By.id("com.example.app:id/addPostButton");
    private By titleField = By.id("com.example.app:id/postTitle");
    private By bodyField = By.id("com.example.app:id/postBody");
    private By submitButton = By.id("com.example.app:id/addPostSubmit");
    private By successMessage = By.id("com.example.app:id/successMessage");

    public AddPostPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void enterBody(String body) {
        driver.findElement(bodyField).sendKeys(body);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }
}
