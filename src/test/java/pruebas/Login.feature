#Author: lrevmesf@hotmail.com
@tag
Feature: Login to sinatra

  @tag1
  Scenario Outline: Login exitoso
    Given navego a la pagina de sinatra
    When Me logueo con el usuario: <user> y el password: <password>
    Then Debo ver la pagina de inicio
    And Debo ver un mensaje de bienvenida

    Examples: 
      | user  | password |
      | frank | sinatra  |

  @tag2
  Scenario Outline: Login fallido
    Given navego a la pagina de sinatra
    When Me logueo con el usuario: <user> y el password: <password>
    Then Debo ver un mensaje de error

    Examples: 
      | user  | password |
      | frenk | sinotra  |
