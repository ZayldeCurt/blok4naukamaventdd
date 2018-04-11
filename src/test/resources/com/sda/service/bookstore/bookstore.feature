Feature:
  Scenario:
    Given I initialize bookstore
    And I pass create book
    When I add book to bookstore
    Then Book ist present in bookstore

  Scenario:
    Given I initialize bookstore
    And I pass create book
    When I add book to bookstore
    Then Book ist present in bookstore
    And I change title
    Then Title is changed