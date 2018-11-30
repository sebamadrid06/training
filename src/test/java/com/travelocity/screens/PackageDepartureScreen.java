package com.travelocity.screens;

import com.travelocity.core.BaseScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PackageDepartureScreen extends BaseScreen {
    public PackageDepartureScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='grid-container standard-padding ']//button")
    private List<WebElement> btnSelectDepartureList;

    public PackageReturnScreen clickFirstDepartureOption(){
        implicitWait(8000);
        click(btnSelectDepartureList.get(0));

        return new PackageReturnScreen(driver);
    }


}
