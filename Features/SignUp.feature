#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Creatio SignUp Feature
  I want to use this feature file to validate all the scenarios to SignUp Feature

Background: Initialize all the pages
Given Initialize all the page objects


  @Regression
  Scenario: Verify SignUp is displayed
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
  	When User click on "AllowAll" button
    Then Cookies Pop-Up should be closed  
    When User click on the signup link
    Then SignUp page should be launched
    
    
     @Regression
  Scenario Outline: Verify SignUp feature to create new accounnt
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
  	When User click on "AllowAll" button
    Then Cookies Pop-Up should be closed  
    When User click on the signup link
    Then SignUp page should be launched
    When User enter details as <Username> and <Password>
    Then Click on continue button
    And Enter company details
    And Click on signup button
    Then Signup should be successful

    Examples: 
      | Username  | Password |
      | Shubham |  Shubham@123 |
