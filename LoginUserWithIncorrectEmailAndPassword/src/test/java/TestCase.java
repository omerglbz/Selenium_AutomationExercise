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

public class TestCase {
    protected static WebDriver driver;

    //setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void incorrectEmailPassword(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a//i[@class='fa fa-home']")).isDisplayed());
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //Verify 'Login to your account' is visible
        Assert.assertEquals("Login to your account",driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText());
        //Enter incorrect email address and password //Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("ss@ss", Keys.TAB, "ss", Keys.TAB, Keys.ENTER);
        //Verify error 'Your email or password is incorrect!' is visible
        Assert.assertEquals("Your email or password is incorrect!",driver.findElement(By.xpath("//form//p[@style='color: red;']")).getText());
    }
    //tearDown
    @After
    public void tearDown() {
        driver.close();
    }
}
