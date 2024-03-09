package US_207;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import javax.tools.Tool;

public class SurveyResponse extends BaseDriver {
    // CREDENTIALS:
    // Name: TestUser
    // Surname: Tester
    // E-mail: lalot13449@artgulin.com
    // Password: Not4You2Know

    @BeforeSuite
    public void setUp() {
        driver.navigate().to("https://demowebshop.tricentis.com/");

    }
    @Test(priority = 2)
    public void login() {

        Actions actionsDriver = new Actions(driver);

        WebElement logIn = driver.findElement(By.xpath("//a[@class='ico-login']"));
        actionsDriver.moveToElement(logIn).click().build().perform();

        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
        actionsDriver.moveToElement(eMail).click().sendKeys("lalot13449@artgulin.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("Not4You2Know").build().perform();

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actionsDriver.moveToElement(loginButton).click().build().perform();
    }

}
