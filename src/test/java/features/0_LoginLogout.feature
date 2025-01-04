Feature: Login scenarios include valid and invalid logins with combination of wrong credentials and Logout scenario

  @Gigatron
  Scenario Outline: Login valid user

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
#    And users clicks on prijava button
#    And user enters email and password for login
#    Then user should be verified login action

    Examples:
      | TC_ID  |
      | IP_001 |