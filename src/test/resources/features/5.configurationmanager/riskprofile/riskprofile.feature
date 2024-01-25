Feature: Probar el ciclo de vida del componente Risk Profile

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción Risk Profile en el menú lateral

  Scenario: TCR-66 Crear un Risk Profile
    Given el usuario hace clic en el botón de agregar un Risk Profile
    When llena el formulario del Risk Profile con los siguientes valores:
      | Field         | Value               |
      | name          | RiskProfileCucumber |
      | displayName   | RiskProfileCucumber |
      | description   | RiskProfileCucumber |
      | riskType      | Fixed Value         |
      | numberHours   | 10                  |
      | numberMinutes | 30                  |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Risk Profile

  Scenario Outline: TCR-67 Editar un Risk Profile
    Given el usuario selecciona el Risk Profile '<profile>' de la lista y hace clic en el botón de editar
    When llena el formulario del Risk Profile con los siguientes valores actualizados:
      | Field       | Value                |
      | name        | RiskProfileCucumber2 |
      | displayName | RiskProfileCucumber2 |
      | description | RiskProfileCucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el Risk Profile
    Examples:
      | profile             |
      | RiskProfileCucumber |

  Scenario Outline: TCR-68 Eliminar un Risk Profile
    When el usuario hace clic en el botón de eliminar del Risk Profile '<profile>'
    Then se muestra un mensaje confirmando la eliminación del Risk Profile
    Examples:
      | profile              |
      | RiskProfileCucumber2 |

