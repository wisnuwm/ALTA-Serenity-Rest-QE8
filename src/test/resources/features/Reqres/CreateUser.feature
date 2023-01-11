Feature: Testing Create user Reqres API
  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Wisnu Munawar" and job "QA Engineer"

  #Silahkan tambahkan skenario negatif case dll