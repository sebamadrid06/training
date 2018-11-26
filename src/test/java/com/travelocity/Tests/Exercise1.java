package com.travelocity.Tests;

import com.travelocity.base.TestBase;
import com.travelocity.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 extends TestBase {

    private ResultsFirstScreen resultsFirstScreen;
    private ResultsSecondScreen resultsSecondScreen;
    private ReviewTripScreen reviewTripScreen;
    private FlightCheckoutScreen flightCheckoutScreen;

    @Test
    public void exercise1() throws InterruptedException {

        HomeScreen homeScreen = new HomeScreen(getDriver());
        homeScreen.clickFlights();
        homeScreen.clickRoundTrip();
        homeScreen.clickOrigin();
        homeScreen.sendOrigin();
        homeScreen.clickDestination();
        homeScreen.sendDestination();
        homeScreen.selectDepartingDate();
        homeScreen.selectReturningDate();
        resultsFirstScreen = homeScreen.clickSearch();
        Assert.assertTrue(resultsFirstScreen.checkSelectButtonsCount());
        Assert.assertTrue(resultsFirstScreen.checkFlightDurationCount());
        Assert.assertTrue(resultsFirstScreen.checkFlightDetailsCount());
        resultsFirstScreen.clickSort();
        Assert.assertTrue(resultsFirstScreen.checkSortingOptions());
        resultsFirstScreen.clickShorterDuration();
        Assert.assertTrue(resultsFirstScreen.checkDurationSort());
        resultsSecondScreen = resultsFirstScreen.clickSelect();
        reviewTripScreen = resultsSecondScreen.clickThirdResult();
        reviewTripScreen.moveDriver();
        Assert.assertTrue(reviewTripScreen.checkDepartureInfo());
        Assert.assertTrue(reviewTripScreen.checkReturningInfo());
        Assert.assertTrue(reviewTripScreen.checkPriceGuarantee());
        Assert.assertTrue(reviewTripScreen.checkPriceTotal());
        flightCheckoutScreen = reviewTripScreen.clickContinueButton();
        Assert.assertTrue(flightCheckoutScreen.checkDatesSummary());
        Assert.assertTrue(flightCheckoutScreen.checkPriceSummary());
        Assert.assertTrue(flightCheckoutScreen.checkPaymentSection());
        Assert.assertTrue(flightCheckoutScreen.checkTravelerDetails());
        Assert.assertTrue(flightCheckoutScreen.checkContinueButton());

        Thread.sleep(4000);
    }


}
