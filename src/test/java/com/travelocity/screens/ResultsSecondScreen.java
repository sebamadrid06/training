package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsSecondScreen extends BaseScreen {
    public ResultsSecondScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sortDropdown")
    private WebElement btnSort;

    @FindBy(xpath = "//*[@id='flightModuleList']//li//div[@class='grid-container standard-padding ']")
    private List<WebElement> resultContainerList;

    @FindBy(xpath = "//*[@id='flightModuleList']//li//div[@class='grid-container standard-padding ']//button")
    private List<WebElement> btnSelectlist;

    @FindBy(id = "forcedChoiceNoThanks")
    private List<WebElement> noThanksOptionList;


    public ReviewTripScreen clickThirdResult(){
        implicitWait(8000);
        click(btnSelectlist.get(2));

        if(!noThanksOptionList.isEmpty()){
            click(noThanksOptionList.get(0));
        }
        return new ReviewTripScreen(driver);
    }

}
