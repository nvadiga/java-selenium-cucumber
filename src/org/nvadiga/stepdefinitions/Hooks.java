package org.nvadiga.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.nvadiga.pageobjects.BasePage;

/**
 * Created by nvadiga on 6/6/2017.
 */
public class Hooks extends BasePage{

    private BasePage basePage;

    public Hooks (BasePage basePage){
        this.basePage = basePage;
        //this.basePage.initDriver();
    }

    @Before
    public void initialize(){
        basePage.baseLogger.logInfo("@Before hook being executed...");
    }

    @After
    public void tearDown(){
        basePage.baseLogger.logInfo("@After hook being executed...");
        basePage.tearDown();
    }
}
