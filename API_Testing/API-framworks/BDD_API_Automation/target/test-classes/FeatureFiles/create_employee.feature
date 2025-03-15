#Feature Name:
#User Story No:
#User Story Name#
# Parent User Story:
# Testcase Suite Name:
#Testcase Id's:
@Execute
Feature: Validate or Verify Create Employee Endpoint Functionality

Background:
Given I load all environment variables
And I setup the Database connection

Scenario: Verify Create Employee Restful API Functionality
Given I provide baseURL for Create Employee
And I create Request Specification object
And I provide request body for the Create Employee EndPoint
And I provide Header and Body for the Request
When I execute the POST Method
Then I print the Response object
And I get the 201 status code
And I validate Response object


Scenario: Verify display Employee Restful API Functionality
Given I provide baseURL for display Employee
And I create Request Specification object
And I provide Header for the Request
When I execute the GET Method
Then I print the Response object
And I get the 200 status code
And I validate Response object of GET API

Scenario: Verify delete Employee Restful API Functionality
Given I provide baseURL for delete Employee
And I create Request Specification object
And I provide Header for the Request
When I execute the DELETE Method
Then I print the Response object
And I get the 200 status code
And I validate Response object of DELETE API
