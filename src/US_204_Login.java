import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class US_204_Login<dependsOnMethods, priority> extends BaseDriver {

    /*  The user's account must be successfully created and verified. */

    // CREDENTIALS:
    // Name: TestUser
    // Surname: TestUser
    // E-mail: TestUser_1234@gmail.com
    // Password: TestUser1234
    @Test
    public void login() {

        //    REGISTER   //
        Actions actionsDriver = new Actions(driver);

        String emailStr = "TestUser_1234@gmail.com";
        String passwordStr = "TestUser1234";

        // Enter the valid credentials in the placeholders provided.
        // Valid e-mail
        WebElement logIn =
                driver.findElement(By.xpath ("//a[@class='ico-login']"));
        actionsDriver.moveToElement(logIn).click().build().perform();

        // Valid Password
        WebElement eMail =
                driver.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
        actionsDriver.moveToElement(eMail).click().sendKeys(emailStr).build().perform();

        // Valid password
        WebElement passwordd =
                driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        actionsDriver.moveToElement(passwordd).click().sendKeys(passwordStr).build().perform();

        // Click on the "Log in" button
        WebElement loginButton =
                driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actionsDriver.moveToElement(loginButton).click().build().perform();

        // Verify that the username or e-mail appears in the upper right corner after logging in.
        WebElement successfullLogin =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'TestUser_1234@gmail.com')]")));

        Assert.assertTrue(successfullLogin.isDisplayed(), "Login was unsuccessful.");
        System.out.println("Login Is Successful.");

    }
}

