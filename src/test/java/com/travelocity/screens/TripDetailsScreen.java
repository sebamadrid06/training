package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TripDetailsScreen extends BaseScreen {
    public TripDetailsScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//article[@class='xsell-details module']//*[@id='dxGroundTransportationModule']//div[@class='uitk-grid flex-layout-custom flex-listing flex-theme-light']//button")
    private List<WebElement> resultsContainer;

    @FindBy(xpath = "//*[@id='departure-airport-automation-label-0']")
    private WebElement detailsFlightFrom;

    @FindBy(xpath = "//*[@id='arrival-airportcode-automation-label-0']")
    private WebElement detailsFlightTo;

    @FindBy(xpath = "//*[@id='trip-summary-hotel-title']")
    private WebElement detailsHotelName;

    @FindBy(xpath = "//*[@class='package-summary-dx Transp']//*[@class='ticket-traveler-info']")
    private WebElement detailsVehicles;

    @FindBy(xpath = "    //div[@class='product-price-list trip-summary-list clearfix pkg-summary']//*[@id='val_amtFlightHotel']")
    private WebElement detailsStartingPrice;

    @FindBy(xpath = "//*[@id='flight-header-traveler']//*[contains(text(),'Roundtrip')]")
    private List<WebElement> roundtripTextList;

    @FindBy(xpath = "//*[@id='val_groundTransport']")
    private WebElement transportPricetext;

    @FindBy(xpath = "//*[@id='dxGroundTransportationModule']//*[@class='separate-price']")
    private WebElement priceSelectedTransport;

    @FindBy(xpath = "(//div[@class='section-header-content']//*[@class='secondary'])[2]")
    private List<WebElement> tripDescription;

    @FindBy(xpath = "//*[@id='trip-summary']//*[contains(text(),'13 nights')]")
    private List<WebElement> tripDescription2;

    @FindBy(xpath = " //*[@id='trip-summary']//button[@class='btn-primary btn-action']")
    private WebElement btnContinue;


    public void clickContinue(){
        click(btnContinue);
    }

    SelectedHotelScreen selectedHotelScreenObject = new SelectedHotelScreen(driver);
    HomeScreen homeScreenObject = new HomeScreen(driver);

    public static int num;

    public void selectCar(){
        implicitWait(2000);
        click(resultsContainer.get(0));
    }


    public boolean checkPrice(){

        String value = detailsStartingPrice.getText();
        String startingPrice = selectedHotelScreenObject.getOldPriceString();

        for (int i = 0; i<value.length();i++){
            String trimmedCurrentValue = value.substring(1,4);


            int intCurrentValue  = Integer.parseInt(trimmedCurrentValue);

            if(value.charAt(i)=='.'){

                if(value.charAt(i+1)>5){
                    setNum(intCurrentValue+1);
                }

            }
        }
        String trimmedOldValue = startingPrice.substring(1,4);
        int intOldValue = Integer.parseInt(trimmedOldValue);
        return(TripDetailsScreen.getNum()==intOldValue);
            }


    public boolean checkCities(){
        return detailsFlightFrom.getText().equals(homeScreenObject.getFlyingFrom()) && detailsFlightTo.getText().equals(homeScreenObject.getFlyingTo());

    }


    public boolean checkTransportPrice(){
        return transportPricetext.getText().substring(1,4).equals(priceSelectedTransport.getText().substring(1,4));
    }

    public boolean checkTripDescription(){
        int state = 0;
        implicitWait(5000);
        if(!tripDescription.isEmpty()){
            return tripDescription.get(0).getText().contains("13 nights");
        }
        if(!tripDescription2.isEmpty()){
            return tripDescription2.get(0).getText().contains("13 nights");
        }

        if(!tripDescription.isEmpty()){
            return tripDescription.get(0).getText().contains("flight + hotel");
        }
        if(!roundtripTextList.isEmpty()){
            return true;
        }


        return false;
    }

    public boolean checkFlightAndHotel(){

        if(!tripDescription.isEmpty()){
            return tripDescription.get(0).getText().contains("flight + hotel");
        }
        if(!roundtripTextList.isEmpty()){
            return true;
        }

        return false;
    }


    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        TripDetailsScreen.num = num;
    }
}
