Feature: This feature check and verify all items of Laptop racunari page

  @Gigatron1
  Scenario Outline: Check all items of Laptop racunari page

    Given a user reads test data from "gigatron" "laptop" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And users clicks proizvodi button
    And users clicks laptop racunari item
    And users clicks laptop racunari sub item
    And users clicks filter button
#    And users clicks more filters

    Examples:
      | TC_ID  |
      | IP_001 |