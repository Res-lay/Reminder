Feature: Add friend to friend list

  Scenario: Adding friend with a name and a date of birth
    Given I have an empty friend list
    When I add a friend with name "Alice" and the date of birth 1990-10-15
    Then There is Alice in friends list