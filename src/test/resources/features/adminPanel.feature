
Feature: Use admin panel

  Scenario: Success authorization
    Given Open "http://test-app.d6.dev.devcaz.com/admin/login" site
    When  Input login "admin1" on field
    And  Input password "[9k<k8^z!+$$GkuP" on field
    And  Click button 'Sign in'
    Then Dashboard is loaded

    Scenario: Open user table
      Given Open "http://test-app.d6.dev.devcaz.com/admin/login" site
      When  Input login "admin1" on field
      And  Input password "[9k<k8^z!+$$GkuP" on field
      And  Click button 'Sign in'
      And  Click button bar 'User'
      And Open side menu
      And Click button 'Players'
      Then Table user open

  Scenario: Sort table User
    Given Open "http://test-app.d6.dev.devcaz.com/admin/login" site
    When  Input login "admin1" on field
    And  Input password "[9k<k8^z!+$$GkuP" on field
    And  Click button 'Sign in'
    And  Click button bar 'User'
    And Open side menu
    And Click button 'Players'
    And Click sort button 'UserName'
    Then Table sorted


