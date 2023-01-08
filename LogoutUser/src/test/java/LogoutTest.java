import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogoutTest {
    WebDriver driver;
    //setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void logoutTest(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());
        //Enter correct email address and password //Click 'login' button
        driver.findElement(By.name("email")).sendKeys("ss@ss", Keys.TAB, "ss", Keys.TAB, Keys.ENTER);
        //Verify that 'Logged in as username' is visible
        String expectedLoginName = "Logged in as ss";
        String actualLoginName = driver.findElement(By.xpath("//li//a//b")).getText();
        Assert.assertTrue(expectedLoginName.contains(actualLoginName));
        //Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        //Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());
    }

    //tearDown
    @After
    public void tearDown() {
        driver.close();
    }
}
