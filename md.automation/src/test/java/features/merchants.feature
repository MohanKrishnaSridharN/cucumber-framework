Feature: Merchants test
  As a ECP user I should be able to manage Merchants Settings and Locations

  Scenario: Enable Mervchant Status
    Given ECP user login to the application
    When I able to see all merchants in Merchants tab
    And I able to search desired Merchant
    Then Click on More button
    And Click on Seeting
    When Merchant Settings pop up opened
    Then Change status to Enabled
    And Save changes
    And Validate status changed to Enabled

