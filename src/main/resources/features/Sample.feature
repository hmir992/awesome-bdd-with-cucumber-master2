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
    
    