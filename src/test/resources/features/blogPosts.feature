Feature: Get comments by post id
  Scenario: comments by post id
    Given I build request with baseUri "https://jsonplaceholder.typicode.com/"
    When use path "comments"
    And make get request with "postId" value 1
    Then request should be completed with status 200 and second comment with email "Jayne_Kuhic@sydney.com"
