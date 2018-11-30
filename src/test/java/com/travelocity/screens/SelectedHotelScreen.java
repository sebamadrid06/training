package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectedHotelScreen extends BaseScreen {
    public SelectedHotelScreen(WebDriver driver) {
        super(driver);
    }

    FlightHotelResultScreen object = new FlightHotelResultScreen(driver);

    @FindBy(id = "hotel-name")
    private WebElement hotelName;

    @FindBy(xpath = "//div[@class='lead-price']//a[@class='price link-to-rooms ']")
    private WebElement hotelPrice;

    @FindBy(xpath = "//*[@class='rating-superlative bold']")
    private WebElement hotelRating;

    @FindBy(xpath = "//*[contains(text(),'guest rating')]")
    private WebElement hotelRating2;


    @FindBy(xpath = "//section[@id='rooms-and-rates']//span[@class='btn-label']")
    private List<WebElement> roomResultsList;

    @FindBy(xpath = "//*[@class='cross-out-price']")
    private WebElement oldPrice;


    public static String oldPriceString;
    public static String hotelPriceString;
    public static String hotelNameString;


    public void newTab(){
        driverToNewWindow();
    }

    public boolean checkPageElements() {
        implicitWait(8000);
        setHotelNameString(hotelName.getText());
        setHotelPriceString(hotelPrice.getText());
        setOldPriceString(oldPrice.getText());
        return (
                hotelName.getText().equals(object.getHotel()) && hotelPrice.getText().equals(object.getHotelPrice()) &&
                        hotelRating2.getText().substring(0, 3).equals(object.getHotelRating())
        );
    }

    public PackageDepartureScreen clickFirstResult(){
        clickOnNotClickable(roomResultsList.get(0));

        return new PackageDepartureScreen(driver);
    }

    public static String getHotelPriceString() {
        return hotelPriceString;
    }

    public static void setHotelPriceString(String hotelPriceString) {
        SelectedHotelScreen.hotelPriceString = hotelPriceString;
    }

    public String getHotelNameString() {
        return hotelNameString;
    }

    public static void setHotelNameString(String hotelNameString) {
        SelectedHotelScreen.hotelNameString = hotelNameString;
    }

    public String getOldPriceString() {
        return oldPriceString;
    }

    public static void setOldPriceString(String oldPriceString) {
        SelectedHotelScreen.oldPriceString = oldPriceString;
    }
}
