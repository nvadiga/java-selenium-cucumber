package org.nvadiga.pageobjects;

import org.nvadiga.logging.BaseLogger;
import org.nvadiga.objects.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

/**
 * Created by nvadiga on 3/6/2017.
 */
public class BasePage {
    public static WebDriver driver;
    public static final BaseLogger baseLogger = new BaseLogger();

    public void initDriver(Properties browserSettings){

        switch (browserSettings.getProperty("Browser").toLowerCase()){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver",browserSettings.getProperty("exe_location"));
                driver = new ChromeDriver();
                baseLogger.logInfo("Initialized Chrome driver...");
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver",browserSettings.getProperty("exe_location"));
                driver = new FirefoxDriver();
                baseLogger.logInfo("Initialized Firefox driver...");
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver",browserSettings.getProperty("exe_location"));
                driver = new EdgeDriver();
                baseLogger.logInfo("Initialized Edge driver");
                break;
        }
    }

    public void tearDown(){
        driver.close();
    }

    public LandingPage getURL(String URL){
        driver.get(URL);
        return PageFactory.initElements(driver,LandingPage.class);
    }

    public void click(WebElement webElement){
        try{
            webElement.click();
        }catch (NoSuchElementException e){
            baseLogger.logError("Unable to do click opertaion "+e.getMessage());
            throw new NoSuchElementException("Unable to click web element");
        }catch (ElementNotVisibleException e){
            moveTo(webElement);
            webElement.click();
        }
    }

    public void moveTo(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public void enterText(WebElement webElement, String text){
        webElement.sendKeys(text);
    }

    public WebElement findElement(String identifier){
        return driver.findElement(By.xpath("//*[contains(@id,'"+identifier+"')]"));
    }

    public WebElement findElement(String type, String identifier){
        return driver.findElement(By.xpath("//"+type+"[contains(@id,'"+identifier+"')]"));
    }

    public void doAction(String actionName, Data data){
        switch (actionName.toLowerCase()){
            case "type" : enterText(findElement(data.getType(),data.getIdentifier()),data.getValue());
                break;
            case "click": click(findElement(data.getIdentifier()));
                break;
            default: //??
        }
    }
}

