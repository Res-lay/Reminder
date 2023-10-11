Feature: Get reminder from app

  Scenario: Checking for a birthday reminder
    Given I have a list of people
      | Name  | Birthday   |
      | Alice | 1990-10-12 |
      | Bob   | 1995-09-30 |
    When Today is Alice birthday
    Then I receive a birthday reminder for Alice
