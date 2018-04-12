Feature:
  Scenario: I can calcualate null number
    Given I initialize stringCalculator
    And I pass null value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario Outline: I can calculate mulitple values
    Given I initialize stringCalculator
    And I pass multiple <valuer> value
    When I trigger calculate function
    Then I get <result> as a result
    Examples:
      | valuer    | result |
      | 5:4:2     | 11     |
      | 8:1       | 9      |
      |           | 0      |
      | 5         | 5      |
      | 5:  4,,5, | 14     |


#  Scenario: I can calculate single number
#    Given I initialize stringCalculator
#    And I pass multiple 5 value
#    When I trigger calculate function
#    Then I get 5 as a result
#
#
#  Scenario: I can calculate blank number
#    Given I initialize stringCalculator
#    And I pass multiple   value
#    When I trigger calculate function
#    Then I get 0 as a result
#
#  Scenario: I can calculate two number
#    Given I initialize stringCalculator
#    And I pass multiple 2,5 value
#    When I trigger calculate function
#    Then I get 7 as a result
#
#  Scenario: I can calculate multiple number
#    Given I initialize stringCalculator
#    And I pass multiple 2,5,6 value
#    When I trigger calculate function
#    Then I get 13 as a result
#
#  Scenario: I can calculate multiple number with whitespaces
#    Given I initialize stringCalculator
#    And I pass multiple 2 ; 5,6,,8 value
#    When I trigger calculate function
#    Then I get 21 as a result

