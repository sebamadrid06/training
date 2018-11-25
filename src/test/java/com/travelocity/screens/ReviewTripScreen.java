package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ReviewTripScreen extends BaseScreen {
    public ReviewTripScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='tripTotals']//span[@class='packagePriceTotal']")
    private WebElement priceTotal;

    @FindBy(xpath = "//*[@class='flightSummaryContainer uitk-col']//div[@class='flex-content']")
    private List<WebElement> departureInfoList;

    @FindBy(xpath = "//div[@class='flex-card flex-tile details OD0 ']")
    private WebElement departingInfo;

    @FindBy(xpath = "//div[@class='flex-card flex-tile details OD1 ']")
    private WebElement returningInfo;

    @FindBy(className = "packagePriceTotal")
    private WebElement priceGuarantee;

    @FindBy(xpath = " //*[@class='continueBookingForm']//button")
    private WebElement btnContinueBooking;

    public FlightCheckoutScreen clickContinueButton(){
    click(btnContinueBooking);

    return new FlightCheckoutScreen(driver);
    }


    public boolean checkPriceGuarantee(){
        return isElementDisplayed(priceGuarantee);
    }

    public boolean checkDepartureInfo(){
        implicitWait(2000);
        return isElementDisplayed(departingInfo);
    }

    public boolean checkReturningInfo(){
        return isElementDisplayed(returningInfo);
    }

    public boolean checkPriceTotal(){
        return isElementDisplayed(priceTotal);
    }

    public void moveDriver(){
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        if(tabs.size()==2){
            driver.switchTo().window(tabs.get(1).toString());
        }
        if(tabs.size()==3){
            driver.switchTo().window(tabs.get(2).toString());
        }
    }

}
