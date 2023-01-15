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

public class VerifyAllProductsAndProductDetailPage {
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
        //Click on 'Products' button
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        //Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
        Assert.assertTrue(allProducts.isDisplayed());
        //The products list is visible
        WebElement productsList = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(productsList.isDisplayed());
        //Click on 'View Product' of first product
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
        //User is landed to product detail page
        WebElement productDetail = driver.findElement(By.xpath("//*[@class='product-information']"));
        Assert.assertTrue(productDetail.isDisplayed());
        //Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        WebElement category = driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = driver.findElement(By.xpath("//b[normalize-space()='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("//b[normalize-space()='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
