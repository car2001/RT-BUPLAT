Feature: Probar el ciclo de vida del componente Location

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: TCR-36 Crear un Location
    Given el usuario crea un company con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
      | taxNumber   | NameProject |
    When hace clic en la opción de New Location
    And llena el formulario de location con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
    Then se muestra un mensaje confirmando que se ha creado el Location

  Scenario: TCR-37 Editar un Location
    Given se tiene un company y location creado
    When  el usuario realiza la edición del Location existente con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
    Then se muestra un mensaje confirmando la edición exitosa del Location

  Scenario: TCR-38 Eliminar un Location
    Given se tiene un company y Location creado
    When el usuario hace click derecho en la opción Delete Location
    Then se muestra un mensaje confirmando que se ha eliminado el Location