Feature: Probar el ciclo de vida del componente Notification Profile

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción Notification Profile en el menú lateral

  Scenario: TCR-63 Crear un Notification Profile
    Given el usuario hace clic en el botón de agregar un Notification Profile
    When llena el formulario del Notification Profile con los siguientes valores:
      | Field       | Value                       |
      | name        | NotificationProfileCucumber |
      | displayName | NotificationProfileCucumber |
      | description | NotificationProfileCucumber |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Notification Profile

  Scenario Outline: TCR-64 Editar un Notification Profile
    Given el usuario selecciona el Notification Profile '<profile>' de la lista y hace clic en el botón de editar
    When llena el formulario del Notification Profile con los siguientes valores actualizados:
      | Field       | Value                        |
      | name        | NotificationProfileCucumber2 |
      | displayName | NotificationProfileCucumber2 |
      | description | NotificationProfileCucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el Notification Profile
    Examples:
      | profile                    |
      | NotificationProfileCucumber|

  Scenario Outline: TCR-65 Eliminar un Notification Profile
    When el usuario hace clic en el botón de eliminar del Notification Profile '<profile>'
    Then se muestra un mensaje confirmando la eliminación del Notification Profile
    Examples:
      | profile                      |
      | NotificationProfileCucumber2 |

