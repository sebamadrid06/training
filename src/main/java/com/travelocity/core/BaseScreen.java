package com.travelocity.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BaseScreen {

    public final int TIMEOUT = 10;
    protected WebDriver driver;
    private WebDriverWait wait;

    public BaseScreen(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,TIMEOUT);
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
        element.click();
    }

    public void type(WebElement element, String string){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch(Exception e){
            e.printStackTrace();
        }
        element.sendKeys(string);
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public void implicitWait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnNotClickable(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element, 0, 0).click().build().perform();
    }

    public void driverToNewWindow(){
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        if(tabs.size()==2){
            driver.switchTo().window(tabs.get(1).toString());
        }
        if(tabs.size()==3){
            driver.switchTo().window(tabs.get(2).toString());
        }
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
