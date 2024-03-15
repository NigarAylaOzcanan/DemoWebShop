import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class US_209_OrderHistory extends BaseDriver {

    // Credentials:
    // Site -> https://demowebshop.tricentis.com/"
    // Email -> mefeget417@sfpixel.com
    // Password -> password258
    Actions actions = new Actions(driver);
    @Test
    public void OrderHistory() {
        // Click on the login button
        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        actions.click(loginBtn).build().perform();

        // Filling E-Mail placeholder
        WebElement emailPlc = driver.findElement(By.id("Email"));
        actions.sendKeys(emailPlc, "mefeget417@sfpixel.com").build().perform();

        // Filling Password placeholder
        WebElement passwordPlc = driver.findElement(By.id("Password"));
        actions.sendKeys(passwordPlc, "password258").build().perform();

        // Submit (Log in) button
        WebElement submitBtn = driver.findElement(By.cssSelector("[value='Log in']"));
        actions.click(submitBtn).build().perform();

        // Navigate to account page
        WebElement myAccount = driver.findElement(By.xpath("//div[@class=\"header-links\"]" +
                "//a[@class=\"account\"]"));
        actions.click(myAccount).build().perform();

        // Click Orders Tab
        WebElement ordersBtn = driver.findElement(By.linkText("Orders"));
        actions.click(ordersBtn).build().perform();

        // Check if details button exist
        WebElement orderDetailsBtn = driver.findElement(By.cssSelector("[value=\"Details\"]"));
        Assert.assertTrue(orderDetailsBtn.isDisplayed(), "Cannot Find Details Button");

        actions.click(orderDetailsBtn).build().perform();

        // Is "Order Information" text displayed ?
        WebElement orderInformationtxt = driver.findElement(By.cssSelector("div[class=\"page-title\"] > h1"));
        Assert.assertTrue(orderInformationtxt.isDisplayed(), "Order Information text doesn't exist");

        WebElement pdfInvoiceBtn = driver.findElement(By.linkText("PDF Invoice"));
        Assert.assertTrue(pdfInvoiceBtn.isEnabled());
        actions.click(pdfInvoiceBtn).build().perform();
    }
}
