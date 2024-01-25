Feature: Probar el ciclo de vida del componente Counter

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción Counter en el menú lateral

  Scenario: TCR-48 Crear un Counter
    Given el usuario hace clic en el botón de agregar un counter
    When llena el formulario del counter con los siguientes valores:
      | Field       | Value           |
      | name        | CounterCucumber |
      | displayName | CounterCucumber |
      | description | CounterCucumber |
      | startAt     | 1               |
      | increment   | 10              |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el counter

  Scenario Outline: TCR-49 Editar un Counter
    Given el usuario selecciona el counter '<counter>' de la lista de contadores y hace clic en el botón de editar
    When  llena el formulario del counter con los siguientes valores actualizados:
      | Field       | Value            |
      | name        | CounterCucumber2 |
      | displayName | CounterCucumber2 |
      | description | CounterCucumber2 |
    And  hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el counter
    Examples:
      | counter      |
      | CounterCucumber |

  Scenario Outline: TCR-50 Eliminar un counter
    When el usuario hace clic en el botón de eliminar del counter '<counter>'
    Then se muestra un mensaje confirmando la eliminación del counter
    Examples:
      | counter      |
      | CounterCucumber2 |