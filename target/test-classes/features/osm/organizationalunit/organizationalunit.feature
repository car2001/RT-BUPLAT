Feature: Probar el ciclo de vida del componente Organizational Unit

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: TCR-29 Crear un Organizational Unit
    Given el usuario crea un company con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
      | taxNumber   | NameProject |
    When hace clic en la opción de New Organizational Unit
    And llena el formulario de organizational unit con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
    Then se muestra un mensaje confirmando que se ha creado el Organizational Unit

  Scenario: TCR-30 Editar un Organizational Unit
    Given se tiene un company y organizational unit creado
    When  el usuario realiza la edición del Organizational Unit existente con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
    Then se muestra un mensaje confirmando la edición exitosa

  Scenario: TCR-31 Ver dependencias de un Organizational Unit
    Given se tiene un company y organizational unit creado
    When el usuario selecciona el "Company" y hace click en ver dependencias
    Then se muestra la tabla con la lista de dependencias asociadas al Organizational Unit

  Scenario: TCR-32 Eliminar un Organizational Unit
    Given se tiene un company y organizational unit creado
    When el usuario hace click derecho en la opción Delete Organizational Unit
    Then se muestra un mensaje confirmando que se ha eliminado el Organizational Unit
