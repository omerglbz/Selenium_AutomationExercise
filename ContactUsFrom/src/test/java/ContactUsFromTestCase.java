import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ContactUsFromTestCase {
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
    public void test01(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());
        //Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
        //Verify 'GET IN TOUCH' is visible
        Assert.assertEquals("GET IN TOUCH",driver.findElement(By.xpath("//div[@class='contact-form']//h2[@class='title text-center']")).getText());
        //Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("omer", Keys.TAB, "gulbuz@gmail.com", Keys.TAB, "Test", Keys.TAB, "Hi");
        //Upload file
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\omerg\\OneDrive\\Masaüstü\\logo.jpeg");
        //Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //Click OK button
        driver.switchTo().alert().accept();
        //Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed());
        //Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[@href='/'])[2]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: orange;']")).isDisplayed());
    }
    //tearDown
    @After
    public void tearDown() {
        driver.close();
    }
}
