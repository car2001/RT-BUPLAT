Feature: Funcionalidad para probar el inicio de sesión

  Scenario Outline: Verificar que el inicio de sesión es exitoso con credenciales válidas
    Given usuario está en la página de inicio de sesión con la url '<url>'
    When usuario ingresa el nombre de '<usuario>' y la '<contraseña>'
    And  clic en el botón de inicio de sesión
    Then el usuario es dirigido a la página principal de la aplicación
    Examples:
      | url                                  | usuario |  | contraseña |
      | http://wedox.sytes.net/BUPLAT_config | jjuarez |  | 1234       |
      | http://wedox.sytes.net/BUPLAT_config | cpingo  |  | 1234       |

  Scenario Outline: Verificar que el campo username, no permita ingresar numeros
    Given usuario está en la página de inicio de sesión con la url '<url>'
    When usuario ingresa el nombre de '<usuario>' y la '<contraseña>'
    Then el campo username no debe permitir ingresar numero
    Examples:
      | url                                  | usuario   |  | contraseña |
      | http://wedox.sytes.net/BUPLAT_config | jjuarez34 |  | 1234       |
      | http://wedox.sytes.net/BUPLAT_config | cpingo    |  | 1234       |
