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

public class ExistingEmailTest {
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
    public void existingEmailTest(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='signup-form']//h2")).isDisplayed());
        //Enter name and already registered email address //Click 'Signup' button
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("ss", Keys.TAB, "ss@ss", Keys.TAB, Keys.ENTER);
        //Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed());
    }

    //tearDown
    @After
    public void tearDown() {
        driver.close();
    }
}
