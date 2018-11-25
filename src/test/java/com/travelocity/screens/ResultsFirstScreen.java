package com.travelocity.screens;

import com.google.common.collect.Ordering;
import com.travelocity.core.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ResultsFirstScreen extends BaseScreen {
    public ResultsFirstScreen(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "sortDropdown")
    private WebElement btnSort;

    @FindBy(xpath = "//*[@id='flightModuleList']//li//div[@class='grid-container standard-padding ']")
    private List<WebElement> resultContainerList;

    @FindBy(xpath = "//*[@id='flightModuleList']//li//div[@class='grid-container standard-padding ']//button")
    private List<WebElement> btnSelectlist;

    @FindBy(xpath = "//*[@id='flightModuleList']//li//div[@class='grid-container standard-padding ']//span[@data-test-id='duration']")
    private List<WebElement> flightDurationList;

    @FindBy(xpath = "//*[@id='flightModuleList']//li//div[@class='grid-container standard-padding ']//span[@class='show-flight-details']")
    private List<WebElement> flightDetailsList;

    Select sortBy = new Select(driver.findElement(By.id("sortDropdown")));
    private List<WebElement> sortOptionsList = sortBy.getOptions();

    public void clickSort() {
        click(btnSort);
    }

    public boolean checkSortingOptions() {
        return (
                sortOptionsList.get(0).getText().equals("Price (Lowest)") &&
                        sortOptionsList.get(1).getText().equals("Price (Highest)") &&
                        sortOptionsList.get(2).getText().equals("Duration (Shortest)") &&
                        sortOptionsList.get(3).getText().equals("Duration (Longest)") &&
                        sortOptionsList.get(4).getText().equals("Departure (Earliest)") &&
                        sortOptionsList.get(5).getText().equals("Departure (Latest)") &&
                        sortOptionsList.get(6).getText().equals("Arrival (Earliest)") &&
                        sortOptionsList.get(7).getText().equals("Arrival (Latest)"));
    }

    public boolean checkSelectButtonsCount() {
        int resultCount = resultContainerList.size();
        int selectCount = btnSelectlist.size();

        return resultCount == selectCount && resultCount != 0;
    }

    public boolean checkFlightDurationCount() {
        int resultCount = resultContainerList.size();
        int durationCount = flightDurationList.size();

        return resultCount == durationCount && durationCount != 0;
    }

    public boolean checkFlightDetailsCount() {
        int resultCount = resultContainerList.size();
        int detailsCount = flightDurationList.size();

        return resultCount == detailsCount && detailsCount != 0;
    }

    public void clickShorterDuration() {
        sortBy.selectByIndex(2);
    }

    public void getDiff() {
        for (int i = 0; i < flightDurationList.size(); i++) {
            int hora = Character.getNumericValue(flightDurationList.get(i).getText().charAt(0));
        }
    }

    public boolean checkDurationSort() {

        implicitWait(6000);
        ArrayList<String> list = new ArrayList<String>();
        boolean isSorted = Ordering.natural().isOrdered(list);

        for (int i = 0; i < flightDurationList.size() - 2; i++) {
            String durationText = flightDurationList.get(i).getText();
            ArrayList<String> mins = new ArrayList<String>();

            for (int c = 0; c < durationText.length(); c++) {
                if (Character.isDigit(durationText.charAt(c)) && durationText.charAt(c) != 'h' && durationText.charAt(c) != 'm') {
                    mins.add(Character.toString(durationText.charAt(c)));
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String s : mins) {
                sb.append(s);
            }

            list.add(sb.toString());

        }

        return isSorted;
    }

    public ResultsSecondScreen clickSelect(){
        click(btnSelectlist.get(0));

        return new ResultsSecondScreen(driver);
    }

}





