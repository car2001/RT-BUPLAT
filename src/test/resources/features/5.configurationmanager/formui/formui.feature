Feature: Probar el ciclo de vida del componente Form UI

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción Form UI en el menú lateral

  Scenario: TCR-57 Crear un Form UI
    Given el usuario hace clic en el botón de agregar un Form UI
    When llena el formulario del Form UI con los siguientes valores:
      | Field       | Value          |
      | name        | FormUICucumber |
      | displayName | FormUICucumber |
      | description | FormUICucumber |
      | comments    | true           |
      | attachments | true           |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Form UI

  Scenario Outline: TCR-58 Editar un Form UI
    Given el usuario selecciona el Form UI '<formUI>' de la lista y hace clic en el botón de editar
    When llena el formulario del Form UI con los siguientes valores actualizados:
      | Field       | Value           |
      | name        | FormUICucumber2 |
      | displayName | FormUICucumber2 |
      | description | FormUICucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el Form UI
    Examples:
      | formUI         |
      | FormUICucumber |

  Scenario Outline: TCR-59 Eliminar un Form UI
    When el usuario hace clic en el botón de eliminar del Form UI '<formUI>'
    Then se muestra un mensaje confirmando la eliminación del Form UI
    Examples:
      | formUI         |
      | FormUICucumber2 |

