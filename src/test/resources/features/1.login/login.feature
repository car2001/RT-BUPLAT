Feature: Funcionalidad para probar el inicio de sesión

  @login @regresion @smoke_test @happy_path
  Scenario Outline: Verificar que el inicio de sesión es exitoso con credenciales válidas
    Given usuario está en la página de inicio de sesión con la url '<url>'
    When usuario ingresa el nombre de '<usuario>' y la '<contraseña>'
    And  clic en el botón de inicio de sesión
    Then el usuario es dirigido a la página principal de la aplicación
    Examples:
      | url                    | usuario |  | contraseña |
      | http://localhost:6208/ | jjuarez |  | 1234       |
      | http://localhost:6208/ | cpingo  |  | 1234       |


  @login @regresion @smoke_test @unhappy_path
  Scenario Outline: Verificar que el campo username, no permita ingresar numeros
    Given usuario está en la página de inicio de sesión con la url '<url>'
    When usuario ingresa el nombre de '<usuario>' y la '<contraseña>'
    Then el campo username no debe permitir ingresar numero
    Examples:
      | url                    | usuario   |  | contraseña |
      | http://localhost:6208/ | jjuarez34 |  | 1234       |
      | http://localhost:6208/ | cpingo    |  | 1234       |
