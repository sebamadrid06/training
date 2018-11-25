package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightCheckoutScreen extends BaseScreen {
    public FlightCheckoutScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "summary")
    private WebElement datesSummary;

    @FindBy(className = "pricing_summary_wrapper")
    private WebElement priceSummary;

    @FindBy(xpath = "//*[@class='allTravelerDetails']")
    private WebElement travelerDetails;

    @FindBy(xpath = "//*[@id='payments']")
    private WebElement paymentSection;

    @FindBy(xpath = "//*[@class='complete-booking-wrapper']//button")
    private WebElement completeBookingButton;


    public boolean checkDatesSummary(){
        return isElementDisplayed(datesSummary);
    }

    public boolean checkPriceSummary(){
        return isElementDisplayed(priceSummary);
    }

    public boolean checkTravelerDetails(){
        return isElementDisplayed(travelerDetails);
    }

    public boolean checkPaymentSection(){
        return isElementDisplayed(paymentSection);
    }

    public boolean checkContinueButton(){
        return isElementDisplayed(completeBookingButton);
    }


}
