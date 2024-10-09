package com.webautomation.pages.pagefactory;

import com.webautomation.base.CommonToAllPage;
import com.webautomation.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends CommonToAllPage {

    public LoginPageFactory(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type=\"email\" and @data-qa=\"hocewoqisi\"]")
    private WebElement usernameElement;

    @FindBy(xpath = "//input[@type=\"password\" and @data-qa=\"jobodapuxe\"]")
    private WebElement passwordElement;

    @FindBy(xpath = "//button[@type=\"submit\" and @data-qa=\"sibequkica\"]")
    private WebElement submitElement;

    @FindBy(id = "js-notification-box-msg")
    private WebElement errorMessageElement;

    public String loginUsingInValidCredentials(String url, String user, String pass){
        openURL(url);
        enterInput(usernameElement,user);
        enterInput(passwordElement,pass);
        clickElement(submitElement);
        return visibilityOfElement(errorMessageElement).getText();
    }

}
