package com.travelocity.Tests;

import com.travelocity.base.TestBase;
import com.travelocity.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2 extends TestBase {


    private ResultsFirstScreen resultsFirstScreen;
    private ResultsSecondScreen resultsSecondScreen;
    private ReviewTripScreen reviewTripScreen;
    private FlightCheckoutScreen flightCheckoutScreen;
    private FlightHotelResultScreen flightHotelResultScreen;
    private SelectedHotelScreen selectedHotelScreen;

    @Test
    public void exercise2() throws InterruptedException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        homeScreen.clickPackage();
        homeScreen.clickFlightHotel();
        homeScreen.select1AdultPackage();
        Assert.assertTrue(homeScreen.checkFlightAndHotel());
        homeScreen.sendOriginPackage();
        homeScreen.sendDestinationPackage();
        homeScreen.selectDepartingDatePackage();
        homeScreen.selectReturningDatePackage();
        flightHotelResultScreen = homeScreen.clickSearchPackage();
        Assert.assertTrue(flightHotelResultScreen.checkTopSummary());
        Assert.assertTrue(flightHotelResultScreen.checkResultsContainer());
        Assert.assertTrue(flightHotelResultScreen.checkPageTitle());
        Assert.assertTrue(flightHotelResultScreen.checkSortBar());
        Assert.assertTrue(flightHotelResultScreen.checkFilter());
        flightHotelResultScreen.sortByPrice();
        flightHotelResultScreen.checkPriceSorting();
        selectedHotelScreen = flightHotelResultScreen.click3StarsResult();
        selectedHotelScreen.newTab();
        Assert.assertTrue(selectedHotelScreen.checkPageElements());


        Thread.sleep(8000);

    }

}
