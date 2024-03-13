package US_204;

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

public class Login<dependsOnMethods, priority> extends BaseDriver {

    /*  The user's account must be successfully created and verified..*/

    // CREDENTIALS:
    // Name: TestUser
    // Surname: TestUser
    // E-mail: TestUser_1234@gmail.com
    // Password: TestUser1234


    @BeforeClass
    public void setUp() {

        // Open the browser and navigate to the website
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @Test
    public void Register() {

        //    REGISTER   //


        Actions actionsDriver = new Actions(driver);
        //Click on the Register button on the homepage
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        actionsDriver.moveToElement(register).click().build().perform();

        //Fill in the "Name, Surname, Gender, E-Mail, Password and Password Verification" fields on the registration page
        WebElement gender = driver.findElement(By.xpath("//*[@id='gender-female']"));
        actionsDriver.moveToElement(gender).click().build().perform();

        WebElement firstName = driver.findElement(By.xpath("//*[@class='text-box single-line']"));
        actionsDriver.moveToElement(firstName).click().sendKeys("TestUser").build().perform();

        WebElement lastName = driver.findElement(By.xpath("//*[@id='LastName']"));
        actionsDriver.moveToElement(lastName).click().sendKeys("TestUser").build().perform();

        WebElement email = driver.findElement(By.xpath("//*[@id='Email']"));
        actionsDriver.moveToElement(email).click().sendKeys("TestUser_1234@gmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//*[@id='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("TestUser1234").build().perform();

        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='ConfirmPassword']"));
        actionsDriver.moveToElement(confirmPassword).click().sendKeys("TestUser1234").build().perform();

        //Click on the Register button
        WebElement registerButton = driver.findElement(By.xpath("//*[@id='register-button']"));
        actionsDriver.moveToElement(registerButton).click().build().perform();


        //    LOGIN   //



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
        System.out.println("Login Is Successful. The results of the survey are displayed below.");


        Tools.wait(3);
        driver.quit();

    }


}

