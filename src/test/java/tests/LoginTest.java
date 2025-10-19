package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverSetup;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverSetup.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void validLoginTest() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String successMsg = driver.findElement(By.className("post-title")).getText();
        Assert.assertTrue(successMsg.contains("Logged In Successfully"), "Login failed!");
    }

    @AfterMethod
    public void teardown() {
        DriverSetup.quitDriver();
    }
}
