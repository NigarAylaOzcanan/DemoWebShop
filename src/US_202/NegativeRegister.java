package US_202;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NegativeRegister extends BaseDriver {
    @Test
    public void Test1(){
        Actions actionsDriver = new Actions(driver);

        driver.get("https://demowebshop.tricentis.com/");

        WebElement register=driver.findElement(By.xpath("//*[@class='ico-register']"));
        actionsDriver.moveToElement(register).click().build().perform();

        WebElement gender=driver.findElement(By.xpath("//*[@id='gender-female']"));
        actionsDriver.moveToElement(gender).click().build().perform();

        WebElement firstName=driver.findElement(By.xpath("//*[@class='text-box single-line']"));
        actionsDriver.moveToElement(firstName).click().sendKeys("Beyza").build().perform();

        WebElement lastName=driver.findElement(By.xpath("//*[@id='LastName']"));
        actionsDriver.moveToElement(lastName).click().sendKeys("ER").build().perform();

        WebElement email=driver.findElement(By.xpath("//*[@id='Email']"));
        actionsDriver.moveToElement(email).click().sendKeys("beyzanur.er@outlook.com").build().perform();

        WebElement password=driver.findElement(By.xpath("//*[@id='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys("Beyza123.").build().perform();

        WebElement confirmPassword=driver.findElement(By.xpath("//*[@id='ConfirmPassword']"));
        actionsDriver.moveToElement(confirmPassword).click().sendKeys("Beyza123.").build().perform();









    }
}
