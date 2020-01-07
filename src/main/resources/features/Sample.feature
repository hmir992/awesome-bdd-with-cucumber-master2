Feature: Reset functionality on login page of Application
  Scenario Outline: Verification of reset button with numbers of credential
    Given Open the Firefox and launch theguardian website
   When I click on the "<number>" news article and Analyse
    And "<search>" to see if the article exists
    #Then verify the article exists
    Examples:
    |number |search |
    |first    |google |
    #|2nd    |bing   |
    #|3rd    |google |


 #   Given Open the Firefox and launch the website
 #   When I click on the "number" news article
  #  And "search engine" to see if the article exists
  #  Then verify the article exists
   #  |number |search engine|
     # |1st    |google        |
     # |2nd  |bing              |
     # |3rd  |google           |


#Feature: Reset functionality on login page of Application
 # Scenario Outline: Verification of reset button with numbers of credential
   # Given Open the Firefox and launch theguardian website
    #When I click on the "number" news article
  # And "search engine" to see if the article exists
   # When Enter the Username "username"and Password "password"
   # Then Reset the credential
   # Examples:
   #   |username  |password         |
   #   |User1     |password1        |
    #  |User2     |password2        |
    #  |User3     |password3        |