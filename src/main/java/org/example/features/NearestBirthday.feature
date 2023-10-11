Feature: Finding the Nearest Birthdays

  Scenario: Determining the nearest birthdays
    Given I have a list of my friends
      | Name   | Birthday      |
      | Alice  | 1990-10-16    |
      | Bob    | 1995-10-13    |
    When I determine the nearest birthdays
    Then The list of nearest birthdays contains Alice and Bob
