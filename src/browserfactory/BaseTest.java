package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    //to open any flexible url
    public void openBrowser(String baseUrl){

        // We are Launching a Chrome browser
        driver = new ChromeDriver();//any driver Firefox any chose like //edgeDriver
        // Open the Url in to Browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        // We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public  void closeBrowser(){
        driver.quit();
    }

}


