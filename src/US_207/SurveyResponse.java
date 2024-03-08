package US_207;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.tools.Tool;

public class SurveyResponse extends BaseDriver {
    // CREDENTIALS:
    // Name: TestUser
    // Surname: Tester
    // E-mail: lalot13449@artgulin.com
    // Password: Not4You2Know
    @Test (priority = 1)
    public void login(){

        driver.navigate().to("https://demowebshop.tricentis.com/");
        Actions actionsDriver=new Actions(driver);

        WebElement logIn=driver.findElement(By.xpath("//a[@class='ico-login']"));
        actionsDriver.moveToElement(logIn).click().build().perform();

        WebElement eMail=driver.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
        actionsDriver.moveToElement(eMail).click().sendKeys("lalot13449@artgulin.com").build().perform();

        WebElement password=driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("Not4You2Know").build().perform();

        WebElement loginButton=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actionsDriver.moveToElement(loginButton).click().build().perform();
    }
}
