import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyTestCasesPageTestCase{
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[contains(text(),'Test Case')]")).click();
        //Verify user is navigated to test cases page successfully
        WebElement testCasePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(testCasePage.isDisplayed());
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
