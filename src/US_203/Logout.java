package US_203;

import Utility.BaseDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Logout extends BaseDriver {

    @BeforeClass
    public void setUp() {

        // Open the browser and navigate to the website
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }
    @Test
    public void logOut() {

    }
}
