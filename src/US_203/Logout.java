package US_203;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Logout extends BaseDriver {

    @BeforeClass
    public void setUp() {

        // Open the browser and navigate to the website
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }
    @Test  (priority = 1)
    public void logIn() {
        Actions actionsDriver = new Actions(driver);

        WebElement logIn =
                driver.findElement(By.xpath("//a[@class='ico-login']"));
        actionsDriver
                .moveToElement(logIn)
                .click()
                .build()
                .perform();

        WebElement eMail =
                driver.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
        actionsDriver
                .moveToElement(eMail)
                .click()
                .sendKeys("lalot13449@artgulin.com")
                .build()
                .perform();

        WebElement password =
                driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        actionsDriver
                .moveToElement(password)
                .click()
                .sendKeys("Not4You2Know")
                .build()
                .perform();

        WebElement loginButton =
                driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actionsDriver
                .moveToElement(loginButton)
                .click()
                .build()
                .perform();
        WebElement successfullLogin=
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'lalot13449@artgulin.com')]")));
        Assert.assertTrue(successfullLogin.isDisplayed(),"Login was unsuccessful.");
        System.out.println("Login Is Successful. The results of the survey are displayed below.");
    }
}
