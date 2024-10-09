package com.webautomation.tests.stg;

import com.webautomation.base.CommonToAllTests;
import com.webautomation.pages.pageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class VWOLoginUsingPOM extends CommonToAllTests {


    @Test
    public void loginTestPositive() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","--guest");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://app.vwo.com/#/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement username = driver.findElement(By.xpath("//input[@type=\"email\" and @data-qa=\"hocewoqisi\"]"));
        username.sendKeys("alisuraj649@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\" and @data-qa=\"jobodapuxe\"]"));
        password.sendKeys("Q#Suraj1998");
        WebElement submit = driver.findElement(By.xpath("//button[@type=\"submit\" and @data-qa=\"sibequkica\"]"));
        submit.click();

        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"Fxg(1) Pend(20px)\"]/child::h1")));
        Assert.assertEquals(dashboard.getText(),"Dashboard");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void loginTestNegative1() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);
        LoginPage login = new LoginPage();
        String expectedErrorMessage = "Your email, password, IP address or location did not match";
        String actualErrorMessage = login.loginWithInValidCredentials("alisuraj649@gmail.com","password123");
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        driver.quit();
    }

    @Test
    public void loginTestNegative2() throws InterruptedException {
        LoginPage login = new LoginPage();
        String expectedErrorMessage = "Your email, password, IP address or location did not match";
        String actualErrorMessage = login.loginWithInValidCredentials("alisuraj649","abc123");
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }


}
