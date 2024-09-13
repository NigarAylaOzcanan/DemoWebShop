import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_201_Register extends BaseDriver {
    @Test
    public void registerTest() {

        WebElement registerBttn = driver.findElement(By.cssSelector(".ico-register"));
        registerBttn.click();

        WebElement gender = driver.findElement(By.cssSelector("#gender-male"));
        gender.click();

        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.sendKeys("Malatyalı");

        WebElement lastName = driver.findElement(By.cssSelector("#LastName"));
        lastName.sendKeys("Tester");

        WebElement email = driver.findElement(By.cssSelector("#Email"));
        email.sendKeys("malatyali_tester@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("mltyTstr.44");

        WebElement confirmPassword = driver.findElement(By.cssSelector("#ConfirmPassword"));
        confirmPassword.sendKeys("mltyTstr.44");

        WebElement registerSubmit = driver.findElement(By.cssSelector("#register-button"));
        registerSubmit.click();
        try {
            String result = driver.findElement(By.cssSelector(".page-body > .result")).getText();
            Assert.assertEquals("Your registration completed", result);
            Tools.wait(2);
            WebElement logout = driver.findElement(By.cssSelector(".header-links > ul > li + li > a.ico-logout"));
            logout.click();
        } catch (Exception e) {
            System.out.println("The specified email already exists.");
        }
    }
}

