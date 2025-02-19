Feature: This feature includes items filtering of Laptop racunari page

  @Gigatron
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
    Then users should verify filtered menu items

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Delete all filtered items

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
    Then users should verify filtered menu items
    And users clicks delete all button
    Then users should verify all deleted filtered items

    Examples:
      | TC_ID  |
      | IP_001 |