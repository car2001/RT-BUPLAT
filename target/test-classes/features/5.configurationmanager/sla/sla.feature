Feature: Probar el ciclo de vida del componente SLA

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción SLA en el menú lateral

  Scenario: TCR-54 Crear un SLA
    Given el usuario hace clic en el botón de agregar un SLA
    When llena el formulario del SLA con los siguientes valores:
      | Field       | Value       |
      | name        | SLACucumber |
      | displayName | SLACucumber |
      | description | SLACucumber |
      | slaType     | Fixed Value |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el SLA

  Scenario Outline: TCR-55 Editar un SLA
    Given el usuario selecciona el SLA '<sla>' de la lista y hace clic en el botón de editar
    When llena el formulario del SLA con los siguientes valores actualizados:
      | Field       | Value        |
      | name        | SLACucumber2 |
      | displayName | SLACucumber2 |
      | description | SLACucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el SLA
    Examples:
      | sla           |
      | SLACucumber  |

  Scenario Outline: TCR-56 Eliminar un SLA
    When el usuario hace clic en el botón de eliminar del SLA '<sla>'
    Then se muestra un mensaje confirmando la eliminación del SLA
    Examples:
      | sla           |
      | SLACucumber2 |

