package US_206;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Ordering extends BaseDriver {

    @Test
    public void Test1() {
        // CREDENTIALS:
        // Firs Name: Caput
        // Last Name: Draconis
        // E-mail: caputdraconis183@gmail.com
        // Password: Lord@183.

        driver.get("https://demowebshop.tricentis.com/");
        Actions actionsDriver = new Actions(driver);

        WebElement logIn = driver.findElement(By.xpath("//a[text()='Log in']"));
        actionsDriver.moveToElement(logIn).click().build().perform();

        WebElement eMail = driver.findElement(By.cssSelector("[id='Email']"));
        actionsDriver.moveToElement(eMail).click().sendKeys("caputdraconis183@gmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("Lord@183.").build().perform();

        WebElement loginButton = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        actionsDriver.moveToElement(loginButton).click().build().perform();


    }
}
