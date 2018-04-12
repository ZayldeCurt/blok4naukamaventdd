Feature:
  Scenario: I can add user to bank
    Given I initialize bank
    And I create user name is Michał and user pesel is 123456
    When I add user
    Then User is present in bank

  Scenario: I can not add duplicate user to bank
    Given I initialize bank
    And I create user name is Michał and user pesel is 123456
    When I add user
    And I add user
    Then User is not present in bank


  Scenario: I can create accoutn for existing user
    Given I initialize bank
    And I create user name is Michał and user pesel is 123456
    And I create account with id 123
    When I add user
    And I add account for user
    Then Account is present in bank

  Scenario: I can not create accoutn for non existing user
    Given I initialize bank
    And I create user name is Michał and user pesel is 123456
    And I create account with id 123
    When I add account for user
    Then Account is not present in bank

  Scenario: I can not add duplicate account for user
    Given I initialize bank
    And I create user name is Michał and user pesel is 123456
    And I create account with id 123
    When I add user
    When I add account for user
    When I add account for user
    Then User has only '1' account in bank

  Scenario: I can deposit some maney to account
    Given I mock bank database for this case
    And I initialize bank
    And I create user name is Michał and user pesel is 123456
    And I create account with id 123
    When I add user
    And I add account for user
    And I deposit 1000 to account with id 123
    Then Account with id 123 has amount of 1000