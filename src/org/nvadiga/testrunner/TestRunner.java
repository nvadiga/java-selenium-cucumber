package org.nvadiga.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by nvadiga on 9/6/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/org/nvadiga/features"},
                plugin ={"pretty","com.cucumber.listener.ExtentCucumberFormatter:results/report.html"},
                glue = {"org/nvadiga/stepdefinitions"})

public class TestRunner {

}
