Feature: Probar el ciclo de vida del componente Role

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Security Manager
    When el usuario selecciona la opción Role en el menú lateral

  Scenario: TCR-39 Crear un Role
    Given el usuario hace clic en el botón de Agregar un rol
    When llena el formulario del rol con los siguientes valores:
      | Field         | Value        |
      | name          | RoleCucumber |
      | displayName   | RoleCucumber |
      | description   | RoleCucumber |
      | useAttributes | false        |
      | isComposite   | false        |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el rol

  Scenario Outline: TCR-40 Editar un Role
    Given el usuario selecciona el role '<rol>' de la lista de roles y hace clic en el botón de editar
    When  llena el formulario del role con los siguientes valores:
      | Field         | Value        |
      | name          | RolCucumber2 |
      | displayName   | RolCucumber2 |
      | description   | RolCucumber2 |
      | useAttributes | false        |
      | isComposite   | false        |
    And  hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el role
    Examples:
      | rol          |
      | RoleCucumber |

  Scenario Outline: TCR-41 Eliminar un Role
    When el usuario hace clic en el botón de eliminar del role '<rol>'
    Then se muestra un mensaje confirmando la eliminación del role
    Examples:
      | rol          |
      | RolCucumber2 |