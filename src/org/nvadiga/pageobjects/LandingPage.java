package org.nvadiga.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by nvadiga on 9/6/2017.
 */
public class LandingPage extends BasePage{

    public void enterText(String identifier,String value){
        enterText(findElement(identifier),value);
    }
}
