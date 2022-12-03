@citiBike
Feature: Networks API

  Scenario:
    Given I am on "http://api.citybik.es" api
    When I am on "v2/networks" path
    And make get request to "visa-frankfurt"
    Then response should have country "DE" and longitude 8.66375F and latitude 50.1072F


