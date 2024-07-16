Feature: Testing form submission and page refresh

  Background:
    Given I open the browser and go to the website


  Scenario: Filling out the form and refreshing the page
    When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
      When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty
     When I fill out the form with:
      | Name   | John Doe       |
      | Email  | john@example.com |
      | Phone  | 123456789      |
      | Message| This is a test |
    And I click on the submit button
    And I should see "Learn Selenium"
    And I click on the refresh button
    Then the form fields should be empty