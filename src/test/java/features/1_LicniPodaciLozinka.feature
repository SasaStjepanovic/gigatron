Feature: Licni podaci i lozinka scenarios include valid and invalid combination of input parameters

  @Gigatron
  Scenario Outline: Licni podaci invalid name (empty)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter name field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of name

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Licni podaci invalid name (only name)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter name field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of name

    Examples:
      | TC_ID  |
      | IP_002 |

  @Gigatron
  Scenario Outline: Licni podaci invalid address (empty)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter address field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of address

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Licni podaci invalid ptt (empty)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter ptt field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of ptt

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Licni podaci invalid ptt (only number)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter ptt field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of ptt

    Examples:
      | TC_ID  |
      | IP_007 |

  @Gigatron
  Scenario Outline: Licni podaci invalid ptt (number less than 5 characters)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter ptt field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of ptt

    Examples:
      | TC_ID  |
      | IP_008 |

  @Gigatron
  Scenario Outline: Licni podaci invalid phone (empty)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter phone field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of phone

    Examples:
      | TC_ID  |
      | IP_001 |

  @Gigatron
  Scenario Outline: Licni podaci invalid phone (only letters)

    Given a user reads test data from "gigatron" "korisnik" by id "<TC_ID>"
    And users accept all cookies
    And users clicks on prijava button
    And user enters email and password for login
    And users clicks on prijavi me button
    And users should verify invisibility of Prijavi button
    And user clicks licni podaci i lozinka item
    Then user should veriify opened page
    And users enter phone field
    And users clicks sacuvaj button
    And users confirm popup message
    Then users verify error message of phone

    Examples:
      | TC_ID  |
      | IP_009 |