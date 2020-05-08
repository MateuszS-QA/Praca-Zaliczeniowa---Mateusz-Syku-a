Feature: Login as user
 Scenario Outline: Login to system as a pre-created user
    Given Open browser with address: https://prod-kurs.coderslab.pl/index.php?controller=addresses
    Then Log in using user:elftiptfinbmkemsjc@awdrt.net with password: coderslab
    Then Choose " + Create new address"
    Then Fill form using "example" table with fields: <alias>, <address>, <city>, <zipCode>, <phone>
   Examples:




    Examples:
      | alias| address     | city       | zipCode| country      | phone      |
      |Mr    |ABC str 16/5 |New York    |12-123  |United Kingdom |123 345 654 |


