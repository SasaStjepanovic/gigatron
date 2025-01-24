Feature: This feature check and verify all items of Laptop racunari page

  @Gigatron
  Scenario Outline: Check all items of Laptop racunari page

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And users clicks proizvodi button
    And users clicks laptop racunari item
    Then users should verify all laptop items

    Examples:
      | TC_ID  |
      | IP_010 |