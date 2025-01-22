Feature: Adresa dostave scenarios include valid and invalid combination of input parameters

  @Gigatron
  Scenario Outline: Adresa dostave valid data

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks adresa dostave item
    Then user should veriify opened page
    And users delete all adresa dostave
    And users enter name field
    And users enter address field
    And users enter ptt field
    And users enter phone field
    And users enter email field
    And users clicks sacuvaj button for address
    And users confirm popup message
    Then users should verify obrisi unos button is visible
    And users delete all adresa dostave


    Examples:
      | TC_ID  |
      | IP_010 |

  @Gigatron
  Scenario Outline: Adresa dostave invalid name (empty)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks adresa dostave item
    Then user should veriify opened page
    And users enter name field
    And users clicks sacuvaj button for address
    And users confirm popup message
    Then users verify error message of name for address

    Examples:
      | TC_ID  |
      | IP_011 |

  @Gigatron
  Scenario Outline: Adresa dostave invalid name (only name)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks adresa dostave item
    Then user should veriify opened page
    And users enter name field
    And users clicks sacuvaj button for address
    And users confirm popup message
    Then users verify error message of name for address

    Examples:
      | TC_ID  |
      | IP_013 |

  @Gigatron
  Scenario Outline: Adresa dostave invalid address (empty)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks adresa dostave item
    Then user should veriify opened page
    And users enter address field
    And users clicks sacuvaj button for address
    And users confirm popup message
    Then users verify error message of address for address

    Examples:
      | TC_ID  |
      | IP_012 |