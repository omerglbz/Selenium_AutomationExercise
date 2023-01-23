import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchProductTestCase {
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
    public void searchProductTest(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsText = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProductsText.isDisplayed());
        //Enter product name in search input and click search button
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement searchArea = driver.findElement(By.xpath("//*[@id='search_product']"));
        jse.executeScript("arguments[0].setAttribute('value','Blue Top');",searchArea);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='submit_search']"));
        jse.executeScript("arguments[0].click();",searchButton);
        //Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(searchedProducts.isDisplayed());

    }
}
