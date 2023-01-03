import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class TestCase extends TestBase {

    @Test
    public void loginEmanilPasswordTestCase(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a//i[@class='fa fa-home']")).isDisplayed());
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //Verify 'Login to your account' is visible
        Assert.assertEquals("Login to your account",driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText());
        //Enter correct email address and password //Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("ss@ss", Keys.TAB, "ss", Keys.TAB, Keys.ENTER);
        //Verify that 'Logged in as username' is visible
        Assert.assertEquals("Logged in as ss",driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//a)[10]")).getText());
        //Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertEquals("ACCOUNT DELETED!",driver.findElement(By.xpath("//*[@class='title text-center']//b")).getText());
    }
}
