package com.travelocity.Tests;

import com.travelocity.base.TestBase;
import com.travelocity.screens.HomeScreen;
import com.travelocity.screens.ResultsScreen;
import org.testng.annotations.Test;

public class HomeTests extends TestBase {

    ResultsScreen resultsScreen;

    @Test
    public void HomeTest() throws InterruptedException {
        HomeScreen homeScreen = new HomeScreen(getDriver());
        homeScreen.clickFlights();
        homeScreen.clickRoundTrip();
        homeScreen.sendOrigin();
        homeScreen.sendDestination();
        homeScreen.selectDepartingDate();
        homeScreen.selectReturningDate();
        resultsScreen = homeScreen.clickSearch();
        Thread.sleep(4000);
    }


}
