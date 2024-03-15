import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class US_208_UsingCouponAndGiftCards extends BaseDriver {
    // CREDENTIALS:
    // Firs Name: Caput
    // Last Name: Draconis
    // E-mail: caputdraconis183@gmail.com
    // Password: Lord@183.
    @Test(priority = 1)
    public void login() {
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

    @Test(priority = 2)
    public void discountCodeAndGiftCards() {

        //The process of adding the product to the cart

        Actions actionsDriver = new Actions(driver);

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

        //When we enter a blank discount code for the product, we receive a warning
        WebElement discountCode = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actionsDriver.moveToElement(discountCode).click().build().perform();

        WebElement discountWarning = driver.findElement(By.xpath("//div[@class='message']"));
        wait.until(ExpectedConditions.visibilityOf(discountWarning));

        Assert.assertTrue(discountWarning.isDisplayed(), "Coupon code correct");

        //The warning we receive when the product's gift coupon is entered blank
        WebElement giftCards = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actionsDriver.moveToElement(giftCards).click().build().perform();

        WebElement giftWarning = driver.findElement(By.xpath("//div[@class='message']"));
        wait.until(ExpectedConditions.visibilityOf(giftWarning));

        Assert.assertTrue(giftWarning.isDisplayed(), "Gift cards code correct");

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
    }

    @Test(priority = 3)
    public void orderingAndControl() {
        Actions actionsDriver = new Actions(driver);

        WebElement billingAddress = driver.findElement(By.xpath("(//div[@class='edit-address'])[1]"));

        //Completion of payment information
        //If there is no address information
        if (billingAddress.isDisplayed()) {

            WebElement adressCountry = driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']"));
            Select ddMenuAdressCountry = new Select(adressCountry);
            ddMenuAdressCountry.selectByVisibleText("United States");

            WebElement adressProvince = driver.findElement(By.xpath("//*[@id='BillingNewAddress_StateProvinceId']"));
            Select ddMenuAdressProvince = new Select(adressProvince);
            ddMenuAdressProvince.selectByVisibleText("Oklahoma");

            WebElement adress = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']"));
            actionsDriver.moveToElement(adress).click().sendKeys("10700 S MUSTANG RD MUSTANG OK 73064-9329 USA").build().perform();

            WebElement city = driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']"));
            actionsDriver.moveToElement(city).click().sendKeys("Oklahoma").build().perform();

            WebElement zipCode = driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']"));
            actionsDriver.moveToElement(zipCode).click().sendKeys("12345").build().perform();

            WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']"));
            actionsDriver.moveToElement(phoneNumber).click().sendKeys("05542926146").build().perform();

            WebElement continueButton = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
            actionsDriver.moveToElement(continueButton).click().build().perform();

        } else {//if you have address details
            WebElement continueButton = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
            actionsDriver.moveToElement(continueButton).click().build().perform();
        }

        WebElement shippingAdress = driver.findElement(By.xpath("//*[@id='shipping-address-select']"));
        Assert.assertTrue(shippingAdress.getText().contains("MUSTANG"), "Shipping address is wrong");

        WebElement inStorePickup = driver.findElement(By.cssSelector("[id='PickUpInStore']"));
        actionsDriver.moveToElement(inStorePickup).click().build().perform();

        WebElement continueButton2 = driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[2]"));
        actionsDriver.moveToElement(continueButton2).click().build().perform();

        Tools.wait(1);
        WebElement creditCardChoice = driver.findElement(By.xpath("(//*[@name='paymentmethod'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardChoice));
        actionsDriver.moveToElement(creditCardChoice).click().build().perform();

        WebElement continueButton3 = driver.findElement(By.xpath("(//*[@class='button-1 payment-method-next-step-button'])"));
        actionsDriver.moveToElement(continueButton3).click().build().perform();

        WebElement creditCardValidation = driver.findElement(By.xpath("//*[text()='Select credit card']"));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Select credit card']"), "Select credit card"));
        Assert.assertTrue(creditCardValidation.getText().contains("credit card"), "Incorrect payment method");

        WebElement creditCardType = driver.findElement(By.xpath("(//*[@id='CreditCardType'])"));
        Select ddMenuCreditCard = new Select(creditCardType);
        ddMenuCreditCard.selectByVisibleText("Visa");

        WebElement cardHolderName = driver.findElement(By.xpath("(//*[@id='CardholderName'])"));
        actionsDriver.moveToElement(cardHolderName).click().sendKeys("Albus Dumbledore").build().perform();

        WebElement cardNumber = driver.findElement(By.xpath("(//*[@id='CardNumber'])"));
        actionsDriver.moveToElement(cardNumber).click().sendKeys("4242424242424242").build().perform();

        WebElement expirationMonth = driver.findElement(By.xpath("//*[@id='ExpireMonth']"));
        Select ddMenuMonth = new Select(expirationMonth);
        ddMenuMonth.selectByVisibleText("01");

        WebElement expirationYear = driver.findElement(By.xpath("//*[@id='ExpireYear']"));
        Select ddMenuYear = new Select(expirationYear);
        ddMenuYear.selectByVisibleText("2032");

        WebElement cardCode = driver.findElement(By.xpath("//*[@id='CardCode']"));
        actionsDriver.moveToElement(cardCode).click().sendKeys("123").build().perform();

        WebElement continueButton4 = driver.findElement(By.xpath("//*[@class='button-1 payment-info-next-step-button']"));
        actionsDriver.moveToElement(continueButton4).click().build().perform();

        //Control of product price and total price

        WebElement price = driver.findElement(By.cssSelector("[class='product-unit-price']"));
        String priceStr = price.getText();
        double priceInt = Double.parseDouble(priceStr);

        WebElement total = driver.findElement(By.cssSelector("[class='product-subtotal']"));
        String totalStr = total.getText();
        double totalInt = Double.parseDouble(totalStr);

        Assert.assertTrue(priceInt == totalInt, "The product price is not equal to the total price");

        WebElement confirm = driver.findElement(By.cssSelector("[class='button-1 confirm-order-next-step-button']"));
        actionsDriver.moveToElement(confirm).click().build().perform();

        //Control of the order of the product

        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));
        WebElement titleValidation = driver.findElement(By.cssSelector("[class='title'] strong"));
        System.out.println(titleValidation.getText());

        Assert.assertTrue(titleValidation.getText().contains("successfully"), "Transaction could not be confirmed");
        WebElement continueButton5 = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        actionsDriver.moveToElement(continueButton5).click().build().perform();

    }
}
