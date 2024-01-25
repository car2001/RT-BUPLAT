Feature: Probar el ciclo de vida del componente User Group

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Security Manager
    When el usuario selecciona la opción User Group en el menú lateral

  Scenario: TCR-42 Crear un User Group
    Given el usuario hace click en el botón de Agregar un user group
    When llena el formulario del user group con los siguientes valores:
      | Field       | Value       |
      | name        | UG-Cucumber |
      | displayName | UG-Cucumber |
      | description | UG-Cucumber |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el User Group

  Scenario Outline: TCR-43 Editar un User Group
    Given el usuario selecciona el User Group '<userGroup>' de la lista de Grupo de Usuarios y hace click en el botón de editar
    When llena el formulario del user group con los siguientes valores actualizados:
      | Field       | Value        |
      | name        | UG-Cucumber2 |
      | displayName | UG-Cucumber2 |
      | description | UG-Cucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el User Group
    Examples:
      | userGroup   |
      | UG-Cucumber |

  Scenario Outline: TCR-44 Eliminar un User Group
    When el usuario hace clic en el botón de eliminar del user group '<userGroup>'
    Then se muestra un mensaje confirmando la eliminación del user group
    Examples:
      | userGroup    |
      | UG-Cucumber2 |