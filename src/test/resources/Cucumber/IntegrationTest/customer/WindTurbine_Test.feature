Feature: Support to create/update/delete Open Model Asset Data Service (ADS) based on Wind Farm and Turbines
  As an ADS Modeler,
  I am able to create/update/delete model elements and query using Graph Expression Language
# @RunJustThisTest
Scenario: Create and query Wind Turbine 

   Given the wind farms table _WT_
      | uri               | name           | owner | lat        | lng         |
      | /windfarm/100     | San Ramon      | GE    | 37.767     |-121.9606    |
      | /windfarm/101     | Lake Berryessa | GE    | 38.586     |-122.275     |
      
   And the manufacture table _WT_
      | uri               | name           | address                                                        |
      | /manufacture/100  | GE Energy      | 4200 Wildwood Parkway, Atlanta, GA 30339 USA                   | 
      | /manufacture/101  | Alstom Power   | 3, Avenue André Malraux , 92309 Levallois-Perret Cedex, France | 
    
   And the wind turbines table _WT_
      | uri              |name | parent        |manufacture       |model | frequency | power |towerType | hubHeight |  rotorDiameter | bladeType | ratedWindSpeed | certification | lat        | lng         |
      | /windturbine/100 | 100 | /windfarm/100 | /manufacture/100 | SLE  | 50/60     | 1.5   | MTS      | 65        | 77             | GE40      | 14             |               | 37.7670002 |-121.96057   |
      | /windturbine/101 | 101 | /windfarm/100 | /manufacture/100 | XLE  | 50/60     | 1.5   | MTS      | 80        | 82.5           | GE40      | 11.5           |               | 37.768     |-121.9605667 | 
      | /windturbine/102 | 102 | /windfarm/100 | /manufacture/100 | XLE  | 50/60     | 1.6   | MTS      | 100       | 82.5           | GE403     | 14             |  IEC 61400-1  | 37.7670002 |-121.9606    |

    When a user queries a list of wind farms _WT_
    Then a list of wind farms should be returned _WT_
    | /windfarm/100 |
    | /windfarm/101 |
    When a user queries a list of wind turbine manufatures _WT_
    Then a list of wind turbine manufatures should be returned _WT_
    | /manufacture/100 |
    | /manufacture/101 |
    When a user queries a list of wind turbines _WT_
    Then a list of wind turbines should be returned _WT_
    | /windturbine/100 |
    | /windturbine/101 |
    | /windturbine/102 |  
    
Scenario: Create/Validate Digital Signature for Wind Turbine  
    Given the wind turbine "WT01" with digital signature _WT_
      | uri               | model | frequency | power |towerType | hubHeight |  rotorDiameter | bladeType | ratedWindSpeed | certification | lat        | lng       |
      | /windturbine/1001 | SLE   | 50/60     | 1.5   | MTS      | 65        | 77             | GE40      | 14             |               | 37.7670002 |-121.96057 |
    When a user queries "WT01" wind turbine _WT_
    Then wind turbine "WT01" signature is "true" _WT_
    Given the wind turbine "WT01" updated _WT_
      | model | frequency | power |towerType | hubHeight |  rotorDiameter | bladeType | ratedWindSpeed | certification | lat        | lng       |
      | XLE   | 50/60     | 1.5   | MTS      | 65        | 77             | GE40      | 14             |               | 37.7670002 |-121.96057 |
    When a user queries "WT01" wind turbine _WT_
    Then wind turbine "WT01" signature is "false" _WT_
    Given the wind turbine "WT01" updated with new signature _WT_
      | model | frequency | power |towerType | hubHeight |  rotorDiameter | bladeType | ratedWindSpeed | certification | lat        | lng       |
      | XLE   | 50/60     | 1.5   | MTS      | 65        | 77             | GE40      | 14             |               | 37.7670002 |-121.96057 |
    When a user queries "WT01" wind turbine _WT_
    Then wind turbine "WT01" signature is "true" _WT_

    
