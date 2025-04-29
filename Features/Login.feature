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
Feature: Creatio Login Feature
  I want to use this feature file to validate all the scenarios to Login Feature


Background: Initialize all the pages
Given Initialize all the page objects

  @Regression
  Scenario: Verify Login feature
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
  	When User click on "AllowAll" button
    Then Cookies Pop-Up should be closed  
    When User enter <Username> and <Password>
    Then Click on login button
    Then Login should be successful

    Examples: 
      | Username  | Password |
      | Sparework673@gmail.com |  Shubhams673@creatio |
      | Bharat@123xyzmail.com |  Bharat@Tech123 | 
