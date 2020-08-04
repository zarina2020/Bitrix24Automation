package com.bitrix24.pages;

import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final static Logger logger = Logger.getLogger(Driver.class);

    @FindBy(name = "USER_LOGIN")
    private WebElement email;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    public void login() {
        String usernameString = ConfigurationReader.getProperty("username");
        String passwordString = ConfigurationReader.getProperty("password");
        email.sendKeys(usernameString);
        password.sendKeys(passwordString, Keys.ENTER);
        //don't print password at work
        logger.info("Login with "+usernameString+" username and "+passwordString+" password");
//        System.out.println("Login with "+usernameString+" username and "+passwordString+" password");
    }
}
