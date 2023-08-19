Feature: Add Items Into Cart

  Scenario Outline: Add Single Product Into Cart
    Given Navigate To GreenKart Applications
    When  Add Items Into Cart and Click On Cart Icon
    #And   Validate <Item> In Checkout Page
    #Then  Place The Order
    #And   Verify The Success Message <Message>
    
    Examples:
    |  Item     | 
    |  Tomato   |
    |  Potato   |
    #|  Tomato   |         |

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
