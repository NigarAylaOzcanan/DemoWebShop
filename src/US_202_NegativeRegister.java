import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class US_202_NegativeRegister extends BaseDriver {

    //The user should be able to see the message "Specified Email Address Already Exists"
    // CREDENTIALS:
    // Name: Beyza
    // Surname: ER
    // E-mail: beyzanur.er@outlook.com
    // Password: Beyza123.
    @Test
    public void Test1() {
        Actions actionsDriver = new Actions(driver);

        //Click on the Register button on the homepage.
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        actionsDriver.moveToElement(register).click().build().perform();

        //Fill in the "Name, Surname, Gender, E-Mail, Password and Password Verification" fields on the registration page
        WebElement gender = driver.findElement(By.xpath("//*[@id='gender-female']"));
        actionsDriver.moveToElement(gender).click().build().perform();

        WebElement firstName = driver.findElement(By.xpath("//*[@class='text-box single-line']"));
        actionsDriver.moveToElement(firstName).click().sendKeys("Beyza").build().perform();

        WebElement lastName = driver.findElement(By.xpath("//*[@id='LastName']"));
        actionsDriver.moveToElement(lastName).click().sendKeys("ER").build().perform();

        WebElement email = driver.findElement(By.xpath("//*[@id='Email']"));
        actionsDriver.moveToElement(email).click().sendKeys("beyzanur.er@outlook.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//*[@id='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("Beyza123.").build().perform();

        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='ConfirmPassword']"));
        actionsDriver.moveToElement(confirmPassword).click().sendKeys("Beyza123.").build().perform();

        //Click on the Register button
        WebElement registerButton = driver.findElement(By.xpath("//*[@id='register-button']"));
        actionsDriver.moveToElement(registerButton).click().build().perform();

        //Try to sign up with the same email address.
        WebElement messageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='The specified email already exists']")));
        Assert.assertTrue(messageText.getText().equals("The specified email already exists"), " ");
        System.out.println(messageText.getText());

    }
}
