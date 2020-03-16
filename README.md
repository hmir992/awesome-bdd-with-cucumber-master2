# awesome-bdd-with-cucumber-master2

Sample Cucumber BDD Framework

Sample working feature

Feature: Verification of news articles on theguardian.com/tone/news is valid
  Scenario Outline: Verification of news articles on theguardian.com by searching keywords in search engine
    Given Open the Firefox and launch theguardian website
    When I click on the "<number>" news article and Analyse
    And "<search>" to see if the article exists
    Then verify the article is true
    Examples:
    |number |search |
    |first    |google |
    #|second  |bing |   not implemented
    #|third   |google | not implemented
    
   geckodriver.exe is included in the project
   
   logger is working in the project with log4j
   
   TODO:
   
   Implement Action classes
   
   Implement different browsers support into this framework for now only firefox works implement chrome and internet explorer
   
   Implement Parallel Execution in Selenium: Session Handling & TestNG Dependency
   - see here : https://www.guru99.com/sessions-parallel-run-and-dependency-in-selenium.html
   
   Implement SPRING into framework maybe branch off to another branch in git before starting this
   
   Look into API testing into this framework if possible
 