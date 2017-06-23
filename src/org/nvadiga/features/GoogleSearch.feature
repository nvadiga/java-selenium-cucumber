Feature: Search Google
  Scenario: Get data from cucumber statements
    Given User navigates to "https://www.google.co.in"
    And Types "hello world!" in "lst-ib" field
    Then Search results should be displayed

 Scenario: Get data from excel
    Given User loads web page as per sheet "Environment" in excel "C:\Users\Niranjana\IdeaProjects\java-selenium-cucumber-di-maven\input.xlsx"
    And Runs the test as per sheet "Google Search" in excel "C:\Users\Niranjana\IdeaProjects\java-selenium-cucumber-di-maven\input.xlsx"
