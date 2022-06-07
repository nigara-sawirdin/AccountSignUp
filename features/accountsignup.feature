Feature: Account sign up

  Scenario: User can sign up for crowdstreet account
    Given user goes to portfolio account sign up page
    And enters personal information
    And secret password
    And accepts terms and condition
    And validates the captcha
    When user clicks the Create an account button
    Then user can see the crowdstree user home page