Feature: Login scenarios include valid and invalid logins with combination of wrong credentials and Logout scenario

  @Gigatron
  Scenario Outline: Login valid user

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified visibility of Korisnik button
    Then user should be verified login action

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Login invalid user (invalid email)

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified login with wrong email

    Examples:
      | TC_ID  |
      | IP_002 |

  @Gigatron
  Scenario Outline: Login invalid user (empty email)

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified login with wrong email

    Examples:
      | TC_ID  |
      | IP_003 |

  @Gigatron
  Scenario Outline: Login invalid user (wrong password)

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified login with wrong credentials

    Examples:
      | TC_ID  |
      | IP_004 |

  @Gigatron
  Scenario Outline: Login invalid user (wrong email)

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified login with wrong credentials

    Examples:
      | TC_ID  |
      | IP_006 |

  @Gigatron
  Scenario Outline: Login invalid user (empty password)

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified login with empty password

    Examples:
      | TC_ID  |
      | IP_005 |

  @Gigatron
  Scenario Outline: Logout user

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified visibility of Korisnik button
    Then user should be verified login action
    And users take hover over Korisnik item
    And user clicks odjavi me button
    Then user should be verified logout action

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Check Korisnik items on main menu

    Given a user reads test data from "gigatron" "login" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    Then users shoud be verified visibility of Korisnik button
    And users take hover over Korisnik item
    Then users should verify all Korisnik items

    Examples:
      | TC_ID  |
      | IP_001 |