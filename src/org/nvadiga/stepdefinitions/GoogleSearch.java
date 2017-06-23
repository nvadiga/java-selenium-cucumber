package org.nvadiga.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Assert;
import org.nvadiga.objects.BrowserAction;
import org.nvadiga.pageobjects.BasePage;
import org.nvadiga.pageobjects.LandingPage;
import org.nvadiga.testdataextractor.ExcelExtractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by nvadiga on 9/6/2017.
 */
public class GoogleSearch extends BasePage {

    private BasePage basePage;
    private LandingPage landingPage;

    public GoogleSearch(BasePage basePage){
        this.basePage = basePage;
    }

    @Given("^User navigates to \"([^\"]*)\"$")
    public void go_to_url(String URL){
        Properties environment = new Properties();
        try {
            System.out.println("Current directory "+System.getProperty("user.dir"));/*
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+
                    "\\org\\nvadiga\\configuration\\browserSettings.properties");*/
            InputStream inputStream = new FileInputStream("C:\\Users\\Niranjana\\IdeaProjects\\java-selenium-cucumber-di-maven\\src\\org\\nvadiga\\configuration\\browserSettings.properties");
            environment.load(inputStream);
        }catch (IOException e){
            baseLogger.logError("Unable to read browser settings "+e.getMessage());
        }
        basePage.initDriver(environment);
        landingPage = basePage.getURL(URL);
    }

    @When("^Types \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void enter_text(String text, String fieldIdentifier){
        landingPage.enterText(fieldIdentifier,text);
    }

    @Then("^Search results should be displayed$")
    public void check_search_results(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){}
        //Assert.assertEquals(landingPage.getPageTitle(),
    }

    @Given("^User loads web page as per sheet \"([^\"]*)\" in excel \"([^\"]*)\"$")
    public void open_test_data_sheet(String sheetName, String inputFileName){
        Sheet sheet = ExcelExtractor.loadSheet(inputFileName,sheetName);
        Properties environment = ExcelExtractor.getSheetAsProperties(sheet);
        basePage.initDriver(environment);
        basePage.getURL(environment.getProperty("URL"));
    }

    @And("^Runs the test as per sheet \"([^\"]*)\" in excel \"([^\"]*)\"$")
    public void do_actions_from_excel(String sheetName, String inputFileName){
        Sheet sheet = ExcelExtractor.loadSheet(inputFileName,sheetName);
        List<BrowserAction> browserActions = ExcelExtractor.getActionsFromSheet(sheet);
        for(BrowserAction action : browserActions){
            basePage.doAction(action.getAction(),action.getData());
        }
        try{Thread.sleep(10000);}catch (InterruptedException e){}
    }
}
