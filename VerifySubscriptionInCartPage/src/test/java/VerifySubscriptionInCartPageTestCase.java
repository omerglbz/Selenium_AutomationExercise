import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class VerifySubscriptionInCartPageTestCase {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void VerifySubscriptionInCartPageTest() throws InterruptedException {
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //Click 'Cart' button
        driver.findElement(By.linkText("Cart")).click();
        //Scroll down to footer
        Actions actions = new Actions(driver);
        WebElement footer = driver.findElement(By.xpath("//*[@class='footer-widget']"));
        actions.moveToElement(footer);
        //Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//*[@class='footer-widget']//h2"));
        Assert.assertEquals("SUBSCRIPTION", subscription.getText());
        //Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("gulbuzomer@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();
        //Verify success message 'You have been successfully subscribed!' is visible
        WebElement subscribeText = driver.findElement(By.xpath("//*[@class='alert-success alert']"));
        Assert.assertTrue(subscribeText.isDisplayed());
    }
}
