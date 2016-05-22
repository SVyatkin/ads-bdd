Feature: Support to create/update/delete Open Model Asset Data Service (ADS) based on Country/States/Cities hierarchy 
  As an ADS Modeler,
  I am able to create/update/delete model elements and query using Graph Expression Language

Scenario: Create and query Country/States/Cities 

    Given the countries table _ADS_
      | uri               | name    | 
      | /countries/USA    | USA     | 
      | /countries/Canada | Canada  | 
      | /countries/Mexico | Mexico  | 
      
    And the states table _ADS_
      | uri        | name        | parent          |
      | /states/CA | CA          | /countries/USA  |
      | /states/WA | WA          | /countries/USA  |
      
    And the cities table _ADS_
      | uri                  | name        | parent            |
      | /cities/LosAngeles   | LosAngeles  | /states/CA        |
      | /cities/VancouverUSA | Vancouver   | /states/WA        |
      | /cities/Vancouver    | Vancouver   | /countries/Canada |
      
    When a user queries a list of countries _ADS_
    Then a list of countries should be returned _ADS_
    | USA    |
    | Canada |
    | Mexico |
    
    When a user queries a list of countries by city name "Vancouver" _ADS_
    Then a list of countries should be returned _ADS_
    | USA    |
    | Canada |
    
    When a user queries a list of states _ADS_
    Then a list of states should be returned _ADS_
    | CA |
    | WA |
    
    When a user queries a list of cities _ADS_
    Then a list of cities should be returned _ADS_
    | LosAngeles  |
    | Vancouver   |
    | Vancouver   |
    
    
