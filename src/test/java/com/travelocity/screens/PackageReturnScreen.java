package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PackageReturnScreen extends BaseScreen {
    public PackageReturnScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='grid-container standard-padding ']//button")
    private List<WebElement> btnSelectReturnList;

    public TripDetailsScreen clickFirstReturnOption(){
        implicitWait(2000);
        click(btnSelectReturnList.get(0));

        return new TripDetailsScreen(driver);
    }
}
