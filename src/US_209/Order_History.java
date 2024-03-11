package US_209;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Order_History extends BaseDriver {
    Actions actions = new Actions(driver);

    @BeforeClass
    public void InitialProcedure() {
        // Go to site
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void OrderHistory() {
        // Click on the login button
        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        actions.click(loginBtn).build().perform();

    }


    @AfterClass
    public void CloseProcedure() {
        // End Procedure
        waitAndClose();
    }
}
