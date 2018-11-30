package com.travelocity.screens;

import com.google.common.collect.Ordering;
import com.travelocity.core.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


    @FindBy(xpath = "//*[@class='price-col-1']//ul[@class='hotel-ugc']//li[@class='reviewOverall']//ancestor::div[@class='flex-link-wrap']//div[@class='flex-area-primary']//ul[@class='hotel-info']//li[@class='hotelTitle']")
    private List<WebElement> resultsWithStars;

    @FindBy(xpath = "//*[@class='price-col-1']//ul[@class='hotel-ugc']//li[@class='reviewOverall']//ancestor::div[@class='flex-link-wrap']//div[@class='flex-area-secondary']//ul//li[@class='reviewOverall']//span[@aria-hidden='true']")
    private List<WebElement> resultsRatingList;

    @FindBy(xpath = "//*[@class='price-col-1']//ul[@class='hotel-ugc']//li[@class='reviewOverall']//ancestor::div[@class='flex-link-wrap']//div[@class='flex-area-secondary']//li[@class='actualPrice price fakeLink ']")
    private List<WebElement> resultsPricesList;


    public static String hotel;
    public static String hotelPrice;
    public static String hotelRating;



    public SelectedHotelScreen click3StarsResult(){

        for(int i = 0; i<reviewOverallList.size();i++){
    String text = reviewOverallList.get(i).getText();
    if(text.contains("/")){

                if(text.charAt(16)=='3'){
                    implicitWait(1000);
                    setHotel(resultsWithStars.get(i).getText());
                    setHotelPrice(resultsPricesList.get(i).getText());
                    setHotelRating(resultsRatingList.get(i).getText().substring(0,3));
                    clickOnNotClickable(resultsWithStars.get(i));
                    break;
                }

            }
        }


        return new SelectedHotelScreen(driver);
    }


    public static void setHotel(String hotel) {
        FlightHotelResultScreen.hotel = hotel;
    }

    public String getHotel() {
        return hotel;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public static void setHotelPrice(String hotelPrice) {
        FlightHotelResultScreen.hotelPrice = hotelPrice;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public static void setHotelRating(String hotelRating) {
        FlightHotelResultScreen.hotelRating = hotelRating;
    }

    public boolean checkPriceSorting(){
        implicitWait(8000);
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
        implicitWait(8000);
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
