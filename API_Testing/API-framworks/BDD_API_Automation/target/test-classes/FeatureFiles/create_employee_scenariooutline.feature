#Feature Name:
#User Story No:
#User Story Name#
# Parent User Story:
# Testcase Suite Name:
#Testcase Id's:
@Execute
Feature: Validate or Verify Create Employee with scenario outline Functionality

Scenario Outline: Verify Create Employee Restful API Functionality
Given I provide baseURL <BaseURL> for Create Employee
And I create Request Specification object
And I provide request body for the Create Employee EndPoint
And I provide Header and Body for the Request
When I execute the POST Method
Then I print the Response object
And I get the 201 status code
And I validate Response object
Given I provide baseURL <BaseURL> for display Employee
And I create Request Specification object
And I provide Header for the Request
When I execute the GET Method
Then I print the Response object
And I get the 200 status code
And I validate Response object of GET API
Given I provide baseURL <BaseURL> for delete Employee
And I create Request Specification object
And I provide Header for the Request
When I execute the DELETE Method
Then I print the Response object
And I get the 200 status code
And I validate Response object of DELETE API

Examples:
|BaseURL|
|http://localhost:9090/sgtesting/api/v1/employees|
|http://localhost:9090/sgtesting/api/v1/employees|