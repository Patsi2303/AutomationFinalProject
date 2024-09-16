Feature: Booking endpoint
  Background: Booking endpoints should allow to get and create bookings

  Scenario: /booking/{id} should return an specific booking
    Given I perform a GET call to the bookings endpoint with id "2"
    Then I verify that the status code is 200
    And I verify that the body does not have size 0
    #And The booking firstname is "Jim"
    #And The booking lastname is "Wilson"

  Scenario: /booking/{id} should not return an specific booking if id does no exist
    Given I perform a GET call to the bookings endpoint with id "10000000000"
    Then I verify that the status code is 404

  Scenario Outline: /booking should create an employee
    Given I perform a POST call to the create endpoint with the following data
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then I verify that the status code is 200
    And I verify that the body does not have size 0
    And I verify the following data in the body response
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | James     | Bond     | 007        | true        | 2024-10-10 | 2025-01-01 | No              |
      | Anne      | White    | 1000       | false       | 2024-10-10 | 2034-12-12 | Dinner          |
      | Robin     | Banks    | 222        | true        | 2024-10-10 | 2024-12-12 | Lunch           |

  Scenario: /booking should not create an employee with incomplete data
    Given I perform a POST call to the create endpoint with the following incomplete data
      | Alejandro | 111 | true | 2018-01-01 | 2019-01-01 | Breakfast |
    Then I verify that the status code is 400

  Scenario: /booking should create an employee even with data with additional info
    Given I perform a POST call to the create endpoint with the following data with additional info
      | Alejandro | Uriarte | 111 | true | 2018-01-01 | 2019-01-01 | Breakfast | alejandro@gmail.com |
    Then I verify that the status code is 200
    And I verify that the body does not have size 0
    And I verify the following data in the body response
      | Alejandro | Uriarte | 111 | true | 2018-01-01 | 2019-01-01 | Breakfast |