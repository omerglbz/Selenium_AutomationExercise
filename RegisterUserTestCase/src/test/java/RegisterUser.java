import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class RegisterUser extends TestBase {
    @Test
    public void registerUserTest(){
        //Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        // Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //Enter name and email address //Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("abc", Keys.TAB, "abcddcbaa@gmail.com", Keys.TAB, Keys.ENTER);
        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[1]")).isDisplayed());
        //Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456789");
        WebElement daysOption = driver.findElement(By.xpath("//*[@id='days']"));
        Select daysSelect = new Select(daysOption);
        daysSelect.selectByValue("10");
        WebElement monthsOption = driver.findElement(By.xpath("//*[@id='months']"));
        Select monthsSelect = new Select(monthsOption);
        monthsSelect.selectByVisibleText("March");
        WebElement yearsSelect = driver.findElement(By.xpath("//*[@id='years']"));
        Select yearsOption = new Select(yearsSelect);
        yearsOption.selectByIndex(24);
        //Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();
        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("abc", Keys.TAB, "cba", Keys.TAB, "omerglbz", Keys.TAB,
                "Istanbul", Keys.TAB, "Sisli", Keys.TAB, Keys.ARROW_DOWN, Keys.TAB, "sisli", Keys.TAB, "Istnabul", Keys.TAB, "34000", Keys.TAB, "123456");
        //Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        //Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-qa='account-created']")).isDisplayed());
        //Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed());
        //Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-qa='account-deleted']")).isDisplayed());
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }
}
