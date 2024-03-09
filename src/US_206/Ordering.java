package US_206;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

        WebElement computers = driver.findElement(By.cssSelector("[class='inactive']:nth-child(2)>a"));
        actionsDriver.moveToElement(computers).click().build().perform();

        WebElement noteBooks = driver.findElement(By.xpath("(//div[@class='sub-category-item'])[2]//a"));
        actionsDriver.moveToElement(noteBooks).click().build().perform();

        WebElement addtoCart = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        actionsDriver.moveToElement(addtoCart).click().build().perform();

        WebElement shoppingCart = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        actionsDriver.moveToElement(shoppingCart).click().build().perform();

        WebElement emptyValidation = driver.findElement(By.xpath("(//*[@class='product-name'])"));
        Assert.assertTrue(emptyValidation.getText().contains("Laptop"), "Your Shopping Cart is empty");

        WebElement country = driver.findElement(By.xpath("//*[@id='CountryId']"));
        Select ddMenuCountry = new Select(country);
        ddMenuCountry.selectByVisibleText("United States");

        WebElement province = driver.findElement(By.xpath("//*[@id='StateProvinceId']"));
        Select ddMenuProvince = new Select(province);
        ddMenuProvince.selectByVisibleText("Oklahoma");

        WebElement termOfService = driver.findElement(By.xpath("//*[@id='termsofservice']"));
        actionsDriver.moveToElement(termOfService).click().build().perform();

        WebElement checkOut = driver.findElement(By.xpath("//*[@id='checkout']"));
        actionsDriver.moveToElement(checkOut).click().build().perform();

        waitAndClose();

    }
}
