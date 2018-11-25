package com.travelocity.Tests;

import com.travelocity.base.TestBase;
import com.travelocity.screens.HomeScreen;
import com.travelocity.screens.ResultsScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends TestBase {

    ResultsScreen resultsScreen;

    @Test
    public void HomeTest() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(getDriver());
        homeScreen.clickFlights();
        homeScreen.clickRoundTrip();
        homeScreen.clickOrigin();
        homeScreen.sendOrigin();
        homeScreen.clickDestination();
        homeScreen.sendDestination();
        homeScreen.selectDepartingDate();
        homeScreen.selectReturningDate();
        resultsScreen = homeScreen.clickSearch();
        Assert.assertTrue(resultsScreen.checkSelectButtonsCount());
        Assert.assertTrue(resultsScreen.checkFlightDurationCount());
        Assert.assertTrue(resultsScreen.checkFlightDetailsCount());
        resultsScreen.clickSort();
        Assert.assertTrue(resultsScreen.checkSortingOptions());
        resultsScreen.clickShorterDuration();
        Assert.assertTrue(resultsScreen.checkDurationSort());
        
        Thread.sleep(4000);
    }


}
