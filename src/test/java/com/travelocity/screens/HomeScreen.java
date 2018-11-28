package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeScreen extends BaseScreen {

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="tab-flight-tab-hp")
    private WebElement btnFlights;

    @FindBy(id="flight-origin-hp-flight")
    private WebElement flightOrigin;

    @FindBy(id="flight-destination-hp-flight")
    private WebElement flightDestination;

    @FindBy(id="package-destination-hp-package")
    private WebElement flightDestinationPackage;

    @FindBy(id="package-origin-hp-package")
    private WebElement flightOriginPackage;


    @FindBy(id="flight-departing-hp-flight")
    private WebElement flightDepartingDate;

    @FindBy(id="package-departing-hp-package")
    private WebElement flightDepartingDatePackage;


    @FindBy(id="flight-returning-hp-flight")
    private WebElement flightReturningDate;

    @FindBy(id="package-returning-hp-package")
    private WebElement flightReturningDatePackage;

    @FindBy(id="flight-type-roundtrip-label-hp-flight")
    private WebElement btnRoundtrip;

    @FindBy(xpath="//*[@class='datepicker-cal-date']")
    private List<WebElement> calendarDaysList;

    @FindBy(xpath=" //*[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
    private WebElement nextMonth;

    @FindBy(xpath="//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")
    private WebElement btnSearch;

    @FindBy(id="search-button-hp-package")
    private WebElement btnSearchPackage;

    @FindBy(id="tab-package-tab-hp")
    private WebElement btnPackage;

    @FindBy(xpath="//*[@for='fh-fh-hp-package']")
    private WebElement btnFlightHotel;

    @FindBy(xpath="//*[@data-gcw-field-available-for-sub-nav-option='flight-hotel,flight-hotel-car']")
    private WebElement flightOptions;

    @FindBy(xpath="//*[@id='package-rooms-label-hp-package']")
    private WebElement txtRooms;

    @FindBy(xpath="//*[@class='datepicker-cal-month']//*[@data-day='1']")
    private WebElement dayToDepart;

    @FindBy(xpath="//*[@class='datepicker-cal-month']//*[@data-day='14']")
    private WebElement dayToReturn;

    Select adultsCombo = new Select(driver.findElement(By.id("package-1-adults-hp-package")));
    private List<WebElement> sortOptionsList = adultsCombo.getOptions();



    public void clickFlightHotel(){
        click(btnFlightHotel);
    }

    public void clickPackage(){
        click(btnPackage);
    }

    public boolean checkFlightAndHotel(){
        return isElementDisplayed(flightOptions) && isElementDisplayed(txtRooms);
    }

    public void clickRoundTrip(){
        click(btnRoundtrip);
    }

    public void clickFlights(){
        click(btnFlights);
    }

    public void clickOrigin(){
        click(flightOrigin);
        implicitWait(2000);
    }

    public void clickDestination(){
        click(flightDestination);
        implicitWait(1000);
    }

    public void sendOrigin(){
        type(flightOrigin,"LAS");
    }

    public void sendDestination(){
        type(flightDestination, "LAX");
    }

    public void sendOriginPackage(){
        click(flightOriginPackage);
        implicitWait(1000);
        type(flightOriginPackage,"LAS");
    }

    public void sendDestinationPackage(){
        click(flightDestinationPackage);
        implicitWait(1000);
        type(flightDestinationPackage, "LAX");
    }


    public void selectDepartingDate(){
        click(flightDepartingDate);
        click(nextMonth);
        click(nextMonth);
        click(dayToDepart);
    }

    public void selectDepartingDatePackage(){
        click(flightDepartingDatePackage);
        click(nextMonth);
        click(nextMonth);
        click(dayToDepart);
    }

    public void selectReturningDate(){
        implicitWait(2000);
        click(flightReturningDate);
        click(dayToReturn);
    }

    public void selectReturningDatePackage(){
        implicitWait(2000);
        click(flightReturningDatePackage);
        click(dayToReturn);
    }

    public ResultsFirstScreen clickSearch(){
        click(btnSearch);

        return new ResultsFirstScreen(driver);
    }

    public FlightHotelResultScreen clickSearchPackage(){
        click(btnSearchPackage);

        return new FlightHotelResultScreen(driver);
    }

    public void select1AdultPackage(){
        adultsCombo.selectByIndex(0);
    }

}
