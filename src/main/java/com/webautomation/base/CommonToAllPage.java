package com.webautomation.base;

import com.webautomation.driver.DriverManager;
import com.webautomation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPage extends DriverManager {
    public CommonToAllPage(){

    }

    public void openURL(String url){
        switch (url){
            case "ACC":
                url = PropertyReader.getData("VWO_LOGIN_URL_ACC");
                break;
            case "STG":
                url = PropertyReader.getData("VWO_LOGIN_URL_STG");
                break;
            default:
                url = PropertyReader.getData("VWO_LOGIN_URL");
                break;
        }
        DriverManager.getDriver().navigate().to(url);
    }

    public void clickElement(By by){
        DriverManager.getDriver().findElement(by).click();
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void enterInput(WebElement element, String input){
        element.sendKeys(input);
    }

    public void enterInput(By by, String input){
        DriverManager.getDriver().findElement(by).sendKeys(input);
    }

    public WebElement presenceOfElement(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement visibilityOfElement(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement visibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getElement(By by){
        return DriverManager.getDriver().findElement(by);
    }

    public WebElement getElement(WebElement element){
        return element;
    }

}
