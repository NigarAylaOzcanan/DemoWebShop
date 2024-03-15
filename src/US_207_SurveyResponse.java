import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class US_207_SurveyResponse extends BaseDriver {

   /** single-line comments have been added for clarity.*/
   /*  Ensure that the user can actively engage with the community poll,
    receive appropriate notifications if not logged in,
    and access poll results after logging in. */

   // CREDENTIALS:
   // Name: TestUser
   // Surname: Tester
   // E-mail: lalot13449@artgulin.com
   // Password: Not4You2Know

    @Test(priority = 1)
    public void answerPollWithoutLogin() {

        Actions actionsDriver = new Actions(driver);

        // Select the "Excellent" option to answer the questionnaire. (Voting option: "Excellent")
        WebElement answerPoll =
        driver.findElement(By.xpath("//label[contains(text(),'Excellent')]"));
        actionsDriver.moveToElement(answerPoll).click().build().perform();

        // And click on the "Submit" button
        WebElement voteButton =
        driver.findElement(By.cssSelector("#vote-poll-1:nth-child(1)"));
        actionsDriver.moveToElement(voteButton).click().build();

        // if not logged in, a warning message such as 'Only Registered Users Can Vote' should be displayed.
        WebElement warningMsg =
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='block-poll-vote-error-1'])[1]")));

        Assert.assertTrue(warningMsg.isDisplayed());
        System.out.println("Warning message: " + warningMsg.getText());

    }
    @Test(priority = 2)
    public void login() {

        Actions actionsDriver = new Actions(driver);

        String emailStr="lalot13449@artgulin.com";
        String passwordStr="Not4You2Know";

        // Enter the valid credentials in the placeholders provided.
        // Valid e-mail
        WebElement logIn =
        driver.findElement(By.xpath("//a[@class='ico-login']"));
        actionsDriver.moveToElement(logIn).click().build().perform();

        // Valid Password
        WebElement eMail =
        driver.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
        actionsDriver.moveToElement(eMail).click().sendKeys(emailStr).build().perform();

        // Valid password
        WebElement password =
        driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        actionsDriver.moveToElement(password).click().sendKeys(passwordStr).build().perform();

        // Click on the "Log in" button
        WebElement loginButton =
        driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        actionsDriver.moveToElement(loginButton).click().build().perform();

        // Verify that the username or e-mail appears in the upper right corner after logging in.
        WebElement successfullLogin=
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'lalot13449@artgulin.com')]")));

        Assert.assertTrue(successfullLogin.isDisplayed(),"Login was unsuccessful.");
        System.out.println("Login Is Successful. The results of the survey are displayed below.");
    }
    @Test (priority = 3, dependsOnMethods = {"answerPollWithoutLogin","login"} )
    public void surveyRateResults(){

        // After logging in: The user should be able to see the voting rates.
        // And the rates should display the total votes.
        WebElement totalVotes = driver.findElement(By.xpath("(//span[@class='poll-total-votes'])[1]"));

        Assert.assertTrue(totalVotes.isDisplayed(),"Result page is not displayed!");
        System.out.println("Survey Result: " + totalVotes.getText());
    }
}
