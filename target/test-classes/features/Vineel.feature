Feature: Calculate the gratuity

  Scenario: Calculate the gratuity amount with user data
    Given Open browser and Navigate URL
    When Click on yes
    When Enter amount
    When Enter years
    And Click on submit
    Then Generate report and Close browser
