package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ResultsScreen extends BaseScreen {
    public ResultsScreen(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="sortDropdown")
    private WebElement btnSort;

    Select sortBy = new Select(driver.findElement(By.id("sortDropdown")));
    private List<WebElement> sortOptionsList = sortBy.getOptions();
    public void clickSort(){
        click(btnSort);
    }

    public boolean checkSortingOptions(){
       return(
               sortOptionsList.get(0).getText().equals("Price (Lowest)") &&
               sortOptionsList.get(1).getText().equals("Price (Highest)") &&
               sortOptionsList.get(2).getText().equals("Duration (Shortest)") &&
               sortOptionsList.get(3).getText().equals("Duration (Longest)") &&
               sortOptionsList.get(4).getText().equals("Departure (Earliest)") &&
               sortOptionsList.get(5).getText().equals("Departure (Latest)") &&
               sortOptionsList.get(6).getText().equals("Arrival (Earliest)") &&
               sortOptionsList.get(7).getText().equals("Arrival (Latest)"));
    }

}
