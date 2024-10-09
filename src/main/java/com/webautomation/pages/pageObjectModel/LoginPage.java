package com.webautomation.pages.pageObjectModel;

import com.webautomation.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(){
        this.driver = getDriver();
    }

    // Locators
    private By usernameElement = By.xpath("//input[@type=\"email\" and @data-qa=\"hocewoqisi\"]");
    private By passwordElement = By.xpath("//input[@type=\"password\" and @data-qa=\"jobodapuxe\"]");
    private By submitElement = By.xpath("//button[@type=\"submit\" and @data-qa=\"sibequkica\"]");
    private By error_messageElement = By.id("js-notification-box-msg");

    // Actions
    public String loginWithInValidCredentials(String user, String pass){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().to("https://app.vwo.com/#/login");
        driver.findElement(usernameElement).sendKeys(user);
        driver.findElement(passwordElement).sendKeys(pass);
        driver.findElement(submitElement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(error_messageElement));
        return driver.findElement(error_messageElement).getText();
    }

}
