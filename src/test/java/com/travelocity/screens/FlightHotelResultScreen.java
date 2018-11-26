package com.travelocity.screens;

import com.google.common.collect.Ordering;
import com.travelocity.core.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.List;

public class FlightHotelResultScreen extends BaseScreen {
    public FlightHotelResultScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='col playback-summary-content']")
    private WebElement tripSummary;

    @FindBy(id = "resultsContainer")
    private WebElement resultsContainer;

    @FindBy(id = "pageTitleContainer")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@class='sort-bar-column sort-bar-container']")
    private WebElement sortBar;

    @FindBy(className = "filterDetails")
    private WebElement filterDetails;

    @FindBy(xpath = "//*[@class='sort-bar-column sort-bar-container']//li[@class='option']")
    private List<WebElement> sortOptionsList;

    @FindBy(xpath = "//*[@class='price-col-1']//ul[@class='hotel-price']//li[@class='actualPrice price fakeLink ']")
    private List<WebElement> priceContainerList;

    @FindBy(xpath = "//*[@class='price-col-1']//ul[@class='hotel-ugc']//li[@class='reviewOverall']")
    private List<WebElement> reviewOverallList;


    public SelectedHotelScreen click3StarsResult(){
        String[] parts=null;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listChar = new ArrayList<String>();

        for(int i = 0; i<reviewOverallList.size();i++){
    String text = reviewOverallList.get(i).getText();

            if(text.contains("/")){

                if(text.charAt(16)=='3'){
                    System.out.println("RESULTADO"+reviewOverallList.get(i).getText());
                    driver.findElement(By.xpath("//*[@class='price-col-1']//ul[@class='hotel-ugc']//li[@class='reviewOverall']//span[@aria-hidden='true']")).click();
                    break;
                }
            }

        }

        return new SelectedHotelScreen(driver);
    }


    public boolean checkPriceSorting(){
        implicitWait(4000);
        ArrayList<String> list = new ArrayList<String>();
        boolean isSorted = Ordering.natural().isOrdered(list);
        for(int i=0; i<priceContainerList.size();i++){

            list.add(priceContainerList.get(i).getText());


        }

        return isSorted;

    }

    public void sortByPrice(){
        click(sortOptionsList.get(1));
    }


    public boolean checkTopSummary(){
        implicitWait(6000);
        return isElementDisplayed(tripSummary);
    }

    public boolean checkResultsContainer(){
        return isElementDisplayed(resultsContainer);
    }

    public boolean checkPageTitle(){
        return isElementDisplayed(pageTitle);
    }

    public boolean checkSortBar(){
        return isElementDisplayed(sortBar);
    }

    public boolean checkFilter(){
        return isElementDisplayed(filterDetails);
    }





}
