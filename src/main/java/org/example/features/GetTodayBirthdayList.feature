Feature: Getting a list of friends happy birthday today

  Scenario: Getting a list of friends happy birthday today
    Given I have a list of friends
      | Name  | Birthday   |
      | Alice | 2000-10-12 |
      | Bob   | 1999-10-12 |
    When Today "Alice" and "Bob" celebrate their birthday
    Then The friends list happy birthday today contains Alice and Bob