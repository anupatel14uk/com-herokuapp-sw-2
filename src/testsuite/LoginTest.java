package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Enter SuperSecretPassword! password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Verify the ‘Secure Area’ text is display
        String expectedDisplay = "Secure Area";
        String actualDisplay = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);


    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword! password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the error message “Your username is invalid!
        String expectedDisplay = "Your username is invalid!\n" + "×";
        String actualDisplay = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);


    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //    Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the error message “Your username is invalid!"
        String expectedDisplay = "Your password is invalid!\n" + "×";
        String actualDisplay = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);
    }

    @After
    public void ternDown() {
        closeBrowser();
    }


}