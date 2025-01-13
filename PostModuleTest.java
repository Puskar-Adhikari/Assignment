package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddPostPage;
import pages.EditPostPage;
import pages.DeletePostPage;

import java.net.MalformedURLException;
import java.net.URL;

public class PostModuleTest {

    private AppiumDriver<MobileElement> driver;
    private AddPostPage addPostPage;
    private EditPostPage editPostPage;
    private DeletePostPage deletePostPage;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", "path/to/your/app.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        addPostPage = new AddPostPage(driver);
        editPostPage = new EditPostPage(driver);
        deletePostPage = new DeletePostPage(driver);
    }

    @Test
    public void testAddPost() {
        addPostPage.clickAddButton();
        addPostPage.enterTitle("Test Title");
        addPostPage.enterBody("This is a test body.");
        addPostPage.clickSubmitButton();

        boolean result = addPostPage.isSuccessMessageDisplayed();
        if (!result) {
            System.out.println("Add Post: FAILED - Success message not displayed.");
        }
        Assert.assertTrue(result, "Add Post failed.");
    }

    @Test
    public void testEditPost() {
        editPostPage.openPostMenu();
        editPostPage.selectEditOption();
        editPostPage.updateTitle("Updated Title");
        editPostPage.updateBody("Updated body content.");
        editPostPage.clickUpdateButton();

        boolean result = editPostPage.isSuccessMessageDisplayed();
        if (result) {
            System.out.println("Edit Post: PASS");
        }
        Assert.assertTrue(result, "Edit Post failed.");
    }

    @Test
    public void testDeletePost() {
        deletePostPage.openPostMenu();
        deletePostPage.selectDeleteOption();

        boolean result = deletePostPage.isPostDeleted();
        if (!result) {
            System.out.println("Delete Post: FAILED - Post not deleted.");
        }
        Assert.assertTrue(result, "Delete Post failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
