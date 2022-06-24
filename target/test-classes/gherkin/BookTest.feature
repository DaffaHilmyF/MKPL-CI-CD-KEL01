Feature: Book
  As a user I want to add new Book, So that I can managed it later

  Background:
    Given I create an Book instance

    @ValidCredentials
    Scenario Outline: User successfully add new book
      When I input "<title>", "<description>", and "<authors>"
      Then I see the book information is equal to "<title>", "<description>", and "<authors>"
      Examples:
        | title                     | description | authors |
        | Spider man: No Way Home   | lorem ipsum | Kevin   |
        | Spider man: Home Coming   | lorem ipsum | Kevin   |
        | Spider man: Far From Home | lorem ipsum | Kevin   |
        | Spider man: Homeless      | lorem ipsum | Kevin   |

    @InValidCredentials
    Scenario Outline: User tries to input incorrect title
      When I input "<incorrect title>", "<description>", and "<authors>", I see incorrect title error "<message>"
      Examples:
        | incorrect title | description | authors | message                                     |
        |                 | lorem ipsum | Kevin   | title should not be empty                   |
        | a               | lorem ipsum | Kevin   | title's length should more than 1 character |

    @InValidCredentials
    Scenario Outline: User tries to input incorrect description
      When I input "<title>", "<incorrect description>", and "<authors>", I see the incorrect description error "<message>"
      Examples:
        | title                     | incorrect description                                                                                                                                                                                                                                           | authors | message                                             |
        | Spider man: Homeless      |                                                                                                                                                                                                                                                                 | Kevin   | description should not be empty                     |
        | Spider man: Far From Home | A                                                                                                                                                                                                                                                               | Kevin   | description's length should more than 1 character   |
        | Spider man: Coming Soon   | XbEihqDy0MKp78ajhut7sBrmF6ecNX8Dht2YdUW1P0zlLUIRh0GRKyUyEhUupIhZ46ShbZl4c0QU9sXUuP0J6czcqqyTI3Y2ROqjnh6nAttQUSO2fTpItaklSQXvET4kzmSdX5lO8SiGZ30MktzocGCdCBY0qZ8yc9t0WXn2CQa6mrwCNSlb4OuyHpGNeBZq4xLTCiikLAB4i2kATSAkwVp7hEhisnc1vJAzy6He1P9ya0Z7MorUhUjB1bpNq3xM | Kevin   | description's length should less than 255 character |
    @InValidCredentials
    Scenario Outline: User tries to input incorrect authors
      When I input "<title>", "<description>", and "<incorrect authors>", I see the incorrect authors error "<message>"
      Examples:
        | title                | description | incorrect authors | message                    |
        | Spider man: Homeless | Lorem ipsum |                   | author should not be empty |

