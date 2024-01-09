Feature: Probar el ciclo de vida del componente Position

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: TCR-33 Crear un position
    Given el usuario crea un company con los siguientes valores:
      | Field       | Value       |
      | name        | CompanyName |
      | displayName | CompanyName |
      | description | CompanyDesc |
    And el usuario crea un organizational unit con los siguientes valores:
      | Field       | Value           |
      | name        | OrgUnitName     |
      | displayName | OrgUnitName     |
      | description | OrgUnitDesc     |
    When el usuario crea un position dentro del "Organizational Unit" con los siguientes valores:
      | Field       | Value          |
      | name        | PositionName   |
      | displayName | PositionName   |
      | description | PositionDesc   |
    Then se muestra un mensaje confirmando que se ha creado el Position

  Scenario: TCR-34 Editar un position
    Given el usuario tiene un position dentro de un Organizational Unit y un Company
    When el usuario realiza la edición del position con los siguientes valores actualizados:
      | Field       | Nuevo valor     |
      | name        | NuevoNombre     |
      | displayName | NuevoNombre     |
      | description | NuevaDescripción |
    Then se muestra un mensaje confirmando la edición exitosa del Position

  Scenario: TCR-35 Eliminar un Location
    Given el usuario tiene un position dentro de un Organizational Unit y un Company
    When el usuario hace click derecho en la opción Delete Position
    Then se muestra un mensaje confirmando que se ha eliminado el Position