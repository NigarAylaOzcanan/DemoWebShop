import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class US_203_Logout extends BaseDriver {

    /* Verify whether the user is able to
       successfully log out of his/her account.*/

    // CREDENTIALS:
    // Name: TestUser
    // Surname: Tester
    // E-mail: lalot13449@artgulin.com
    // Password: Not4You2Know

    @Test  (priority = 1)
    public void logIn() {

        Actions actionsDriver = new Actions(driver);

        // Click on the "Log in" link in the upper right corner.
        WebElement logIn =
        driver.findElement(By.xpath("//a[@class='ico-login']"));
        actionsDriver.moveToElement(logIn).click().build().perform();

        // Enter the valid credentials in the placeholders provided.
        // Valid e-mail
        WebElement eMail =
        driver.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
        actionsDriver.moveToElement(eMail).click().sendKeys("lalot13449@artgulin.com").build().perform();

        // Valid password
        WebElement password =
        driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("Not4You2Know").build().perform();
        // Click on the "Log in" button
        WebElement loginButton =
        driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actionsDriver.moveToElement(loginButton).click().build().perform();

        // Verify that the username or e-mail appears in the upper right corner after logging in.
        WebElement successfullLogin=
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'lalot13449@artgulin.com')]")));

        Assert.assertTrue(successfullLogin.isDisplayed(),"Login is unsuccessful.");

    }
    @Test (priority = 2,dependsOnMethods = {"logIn"})
    public void logOut(){

        Actions actionsDriver = new Actions(driver);

        // Click on the "Log out" link in the upper right corner.
        WebElement logOut =
        driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        actionsDriver.moveToElement(logOut).click().build().perform();

        // Verify that the user has successfully logged out of the account.
        WebElement successfullLogOut=
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //a[contains(text(),'Log in')]")));

        Assert.assertTrue(successfullLogOut.isDisplayed(), "Logout is unsuccessful");
        System.out.println("Logout Is Successful.");

    }
}
