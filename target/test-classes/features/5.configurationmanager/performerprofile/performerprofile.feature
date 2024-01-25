Feature: Probar el ciclo de vida del componente Performer Profile

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción Performer Profile en el menú lateral

  Scenario: TCR-60 Crear un Performer Profile
    Given el usuario hace clic en el botón de agregar un Performer Profile
    When llena el formulario del Performer Profile con los siguientes valores:
      | Field             | Value                    |
      | name              | PerformerProfileCucumber |
      | displayName       | PerformerProfileCucumber |
      | description       | PerformerProfileCucumber |
      | reusePerformer    | false                    |
      | assignCurrentUser | false                    |
      | assignmentMethod  | By Load                  |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Performer Profile

  Scenario Outline: TCR-61 Editar un Performer Profile
    Given el usuario selecciona el Performer Profile '<profile>' de la lista y hace clic en el botón de editar
    When llena el formulario del Performer Profile con los siguientes valores actualizados:
      | Field       | Value                     |
      | name        | PerformerProfileCucumber2 |
      | displayName | PerformerProfileCucumber2 |
      | description | PerformerProfileCucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el Performer Profile
    Examples:
      | profile                   |
      | PerformerProfileCucumber |

  Scenario Outline: TCR-62 Eliminar un Performer Profile
    When el usuario hace clic en el botón de eliminar del Performer Profile '<profile>'
    Then se muestra un mensaje confirmando la eliminación del Performer Profile
    Examples:
      | profile                   |
      | PerformerProfileCucumber2|

