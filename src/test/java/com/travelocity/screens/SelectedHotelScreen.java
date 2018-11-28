package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedHotelScreen extends BaseScreen {
    public SelectedHotelScreen(WebDriver driver) {
        super(driver);
    }

    FlightHotelResultScreen object = new FlightHotelResultScreen(driver);

    @FindBy(id = "hotel-name")
    private WebElement hotelName;

    @FindBy(xpath = "//div[@class='lead-price']//a[@class='price link-to-rooms ']")
    private WebElement hotelPrice;

    @FindBy(xpath = "//*[@class='reviews-container-outer']//*[@class='rating-superlative bold']")
    private WebElement hotelRating;


    public void newTab(){
        driverToNewWindow();
    }

    public boolean checkPageElements() {
        implicitWait(4000);
        return (
                hotelName.getText().equals(object.getHotel()) && hotelPrice.getText().equals(object.getHotelPrice()) &&
                        hotelRating.getText().substring(0, 3).equals(object.getHotelRating())
        );
    }




}
