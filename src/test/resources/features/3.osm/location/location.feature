Feature: Probar el ciclo de vida del componente Location
  Para poder probar este ciclo de vida se debe tener un company creado.

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: Crear company
    Given el usuario hace click en la opción New Company
    When  llena el formulario del company con los siguientes valores:
      | Field       | Value           |
      | name        | CompanyLocation |
      | displayName | CompanyLocation |
      | description | CompanyLocation |
      | taxNumber   | TX-25           |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el company

  Scenario Outline: TCR-36 Crear un Location
    Given se tiene el company '<company>' y hace clic en la opción de New Location
    When llena el formulario de location con los siguientes valores:
      | Field       | Value      |
      | name        | LocationMX |
      | displayName | LocationMX |
      | description | LocationMX |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el location
    Examples:
      | company         |
      | CompanyLocation |

  Scenario Outline: TCR-37 Editar un Location
    Given se tiene el company '<company>' y el usuario selecciona el location '<location>'
    When  hace clic en el botón de editar para el location seleccionado
    And   realiza la edición del formulario del location con los siguientes valores:
      | Field       | Value       |
      | name        | LocationMX2 |
      | displayName | LocationMX2 |
      | description | LocationMX2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el location
    Examples:
      | company         | location   |
      | CompanyLocation | LocationMX |

  Scenario Outline: TCR-38 Eliminar un Location
    Given se tiene el company '<company>' y el usuario hace click derecho en el location '<location>'
    When  el usuario hace click en la opción Delete Location
    Then  se muestra un mensaje confirmando que se ha eliminado el Location
    Examples:
      | company         | location    |
      | CompanyLocation | LocationMX2 |

  Scenario Outline: Eliminar company
    Given el usuario hace click derecho en el company '<company>'
    When  el usuario hace click en la opción Delete Company
    Then  se muestra un mensaje confirmando que se ha eliminado el company
    Examples:
      | company  |
      | CompanyLocation |