import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class US_201_Register extends BaseDriver {
    @Test
    public void registerTest() {

        driver.get("https://demowebshop.tricentis.com/");
        Tools.wait(2);
        WebElement registerKlick = driver.findElement(By.cssSelector(".ico-register"));
        registerKlick.click();
        Tools.wait(2);
        WebElement maleClick = driver.findElement(By.cssSelector("#gender-male"));
        maleClick.click();
        Tools.wait(2);
        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.sendKeys( "Malatyalı");
        Tools.wait(2);
        WebElement lastName = driver.findElement(By.cssSelector("#LastName"));
        lastName.sendKeys("Tester");
        Tools.wait(2);
        WebElement email = driver.findElement(By.cssSelector("#Email"));
        email.sendKeys("malatyali_tester@gmail.com");
        Tools.wait(2);
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("mltyTstr.44");
        Tools.wait(2);
        WebElement confirmPassword =driver.findElement(By.cssSelector("#ConfirmPassword"));
        confirmPassword.sendKeys("mltyTstr.44");
        Tools.wait(2);
        WebElement clickButton = driver.findElement(By.cssSelector("#register-button"));
        clickButton.click();
        Tools.wait(2);
        try {
            String result = driver.findElement(By.cssSelector(".page-body > .result")).getText();
            Assert.assertEquals("Your registration completed", result);
            Tools.wait(2);
            WebElement logout = driver.findElement(By.cssSelector(".header-links > ul > li + li > a.ico-logout"));
            logout.click();
        } catch (Exception e) {
            System.out.println("Kayıt var. Bu adımı geçebiliriz.");
        }
    }
}

