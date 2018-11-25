package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(id="flight-departing-hp-flight")
    private WebElement flightDepartingDate;

    @FindBy(id="flight-returning-hp-flight")
    private WebElement flightReturningDate;

    @FindBy(id="flight-type-roundtrip-label-hp-flight")
    private WebElement btnRoundtrip;

    @FindBy(xpath="//*[@class='datepicker-cal-date']")
    private List<WebElement> calendarDaysList;

    @FindBy(xpath=" //*[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
    private WebElement nextMonth;

    @FindBy(xpath="//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']")
    private WebElement btnSearch;



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

    public void selectDepartingDate(){
        click(flightDepartingDate);
        click(calendarDaysList.get(4));
    }

    public void selectReturningDate(){
        implicitWait(2000);
        click(flightReturningDate);
        click(nextMonth);
        click(nextMonth);
        click(calendarDaysList.get(0));
    }

    public ResultsScreen clickSearch(){
        click(btnSearch);

        return new ResultsScreen(driver);
    }

}
