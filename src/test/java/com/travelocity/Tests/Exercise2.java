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
    private PackageDepartureScreen packageDepartureScreen;
    private PackageReturnScreen packageReturnScreen;
    private TripDetailsScreen tripDetailsScreen;

    @Test
    public void exercise2() throws InterruptedException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        homeScreen.clickPackage();
        homeScreen.clickFlightHotel();
        Assert.assertTrue(homeScreen.checkFlightAndHotel());
        homeScreen.sendOriginPackage();
        homeScreen.sendDestinationPackage();
        homeScreen.selectDepartingDatePackage();
        homeScreen.selectReturningDatePackage();
        homeScreen.select1AdultPackage();
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
        packageDepartureScreen = selectedHotelScreen.clickFirstResult();
        packageReturnScreen = packageDepartureScreen.clickFirstDepartureOption();
        tripDetailsScreen = packageReturnScreen.clickFirstReturnOption();
        tripDetailsScreen.selectCar();
        Assert.assertTrue(tripDetailsScreen.checkPrice());
        Assert.assertTrue(tripDetailsScreen.checkCities());
        Assert.assertTrue(tripDetailsScreen.checkTransportPrice());
        Assert.assertTrue(tripDetailsScreen.checkTripDescription());
        tripDetailsScreen.clickContinue();

        Thread.sleep(8000);

    }

}
