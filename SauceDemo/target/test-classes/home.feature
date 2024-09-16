Feature: Home page

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
#
    Scenario: Verify that logout button works
      When The home page should be displayed
      And I click on the sidebar button
      And I click on the logout button
      Then Login logo should be displayed

    Scenario Outline: Verify that all products can be added and removed from the cart
      When The home page should be displayed
      And I add to the cart the product "<products1>"
      And I add to the cart the product "<products2>"
      Then The cart icon should display "2"
      And I remove the product "<products2>" from the cart
      Then The cart icon should display "1"
      Examples:
        | products1               | products2               |
        | Sauce Labs Backpack     | Sauce Labs Bike Light   |
        | Sauce Labs Bike Light   | Sauce Labs Bolt T-Shirt |
        | Sauce Labs Bolt T-Shirt | Sauce Labs Onesie       |
        | Sauce Labs Onesie       | Sauce Labs Backpack     |