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
Feature: Creatio cookies Feature
  I want to use this feature file to validate all the scenarios to Cookies Feature

  Background: Initialize all the pages
    Given Initialize all the page objects

  @Sanity
  Scenario: Verify Cookies Pop-Up is displayed
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully

  @Sanity @Regression
  Scenario Outline: Verify Cookies Pop-Up content
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    And Verify Cookies Pop-Up <Content>

    Examples: 
      | Content                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | We may use cookies and similar technologies to collect information about the ways you interact with and use the website, to support and enhance features and functionality, to monitor performance, to personalize content and experiences, for marketing and analytics, and for other lawful purposes. We also may share information about your use of our site with our social media, advertising and analytics partners who may combine it with other information that you’ve provided to them or that they’ve collected from your use of their services. Please, see more details on the "About" tab |

  @Sanity
  Scenario: Verify Cookies Pop-Up logos
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    And Verify Cookies Pop-Up logos are displayed successfully

  @Sanity
  Scenario: Verify Cookies Pop-Up Selection buttons
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    And Verify Cookies Pop-Up selection buttons are displayed successfully

  @Regression
  Scenario: Verify Cookies Pop-Up Switch buttons
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    And Verify Cookies Pop-Up switch buttons are displayed successfully

  @Regression @Smoke
  Scenario: Verify Cookies Pop-Up Expanded view
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    When User click on the show details link
    Then Verify Cookies Pop-Up should be displayed in expanded view

  @Regression @Smoke
  Scenario: Verify Accept all Cookies feature
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    When User click on "AllowAll" button
    Then Cookies Pop-Up should be closed

  @Regression @Smoke
  Scenario: Verify Deny all Cookies feature
    Given Launch the application
    Then Verify cookies Pop-Up is displayed successfully
    When User click on "Deny" button
    Then Cookies Pop-Up should be closed
