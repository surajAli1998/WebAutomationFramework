package com.webautomation.driver;

import com.webautomation.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init(){
        String browser;
        browser = PropertyReader.getData("browser");
        if (browser != null) {
            switch (browser) {
                case "chrome" -> {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--size-maximized", "--guest");
                    driver = new ChromeDriver(chromeOptions);
                }
                case "edge" -> {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--size-maximized", "--guest");
                    driver = new EdgeDriver(edgeOptions);
                }
                default -> System.out.println("Browser not found");
            }
        }
        else{
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--size-maximized", "--guest");
            driver = new ChromeDriver(chromeOptions);
        }
    }

    public static void down(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
