## Goal

Goal of this project is to show sample web testing framework, integrating all those wonderful languages and tools out there like Java, Cucumber, Junit, Apache POI, ExtenetReports etc.

## How to use

You can kick start your framework development by cloning this repository.

`git clone https://github.com/nvadiga/java-selenium-cucumber.git`

You can use direct Gherkin statements like

`Given User navigates to "https://www.google.co.in"`
(Just replace url in quotes with required url)

Or keep test definitions outside the framework in an Excel and use it like

`And Runs the test as per sheet "Google Search" in excel "input.xlsx"`

## Test Results

Framework uses Cucumber ExtentReport for test results reporting. You can find html report under "results" folder which will be created after the test run.

## What next?

* Add more web actions like select etc.
* Add validation methods.
* Add fillForm method which makes filling bigger forms easy.
* and much more!!
