import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Credentials:
// Name=Daniel
// Last name=Radcliffe
// E-mail=xamoni6060@fryshare.com
// Password=Daniel.123

public class US_205_NegativeLogin extends BaseDriver {
    @Test(priority = 1)
    public void negativeLogin1() {

        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.moveToElement(login).click().build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(loginButton).click().build().perform();

        WebElement unsuccessfulLogin = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"));
        System.out.println(unsuccessfulLogin.getText());
        Assert.assertTrue(unsuccessfulLogin.getText().contains("Login was unsuccessful."));
    }

    @Test(priority = 2)
    public void negativeLogin2() {
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.moveToElement(login).click().build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
        actions.moveToElement(email).click().sendKeys("xamoni6060@fryshare.com").build().perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(loginButton).click().build().perform();

        WebElement unsuccessfulLogin = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"));
        System.out.println(unsuccessfulLogin.getText());
        Assert.assertTrue(unsuccessfulLogin.getText().contains("Login was unsuccessful."));
    }

    @Test(priority = 3)
    public void negativeLogin3() {
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.moveToElement(login).click().build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));

        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        actions.moveToElement(password).click().sendKeys("Daniel.123").build().perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(loginButton).click().build().perform();

        WebElement unsuccessfulLogin = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"));
        System.out.println(unsuccessfulLogin.getText());
        Assert.assertTrue(unsuccessfulLogin.getText().contains("Login was unsuccessful."));
    }

    @Test(priority = 4)
    public void negativeLogin4() {
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.linkText("Log in"));
        actions.moveToElement(login).click().build().perform();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));

        WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
        actions.moveToElement(email).click().sendKeys("invalid_36boys@hotmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        actions.moveToElement(password).click().sendKeys("invalidmail.password").build().perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actions.moveToElement(loginButton).click().build().perform();

        WebElement unregisteredCustomer = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li"));
        System.out.println(unregisteredCustomer.getText());
        Assert.assertTrue(unregisteredCustomer.getText().contains("No customer account found"));
    }
}
