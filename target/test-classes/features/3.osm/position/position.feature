Feature: Probar el ciclo de vida del componente Position
  Para poder probar este ciclo de vida se debe tener un company y un organizational unit creado.

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: Crear company
    Given el usuario hace click en la opción New Company
    When  llena el formulario del company con los siguientes valores:
      | Field       | Value           |
      | name        | CompanyPosition |
      | displayName | CompanyPosition |
      | description | CompanyPosition |
      | taxNumber   | TX-25           |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el company

  Scenario Outline: Crear Organizational Unit
    Given se tiene el company '<company>' y hace clic en la opción de New Organizational Unit
    When  llena el formulario de organizational unit con los siguientes valores:
      | Field       | Value       |
      | name        | OU-Position |
      | displayName | OU-Position |
      | description | OU-Position |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Organizational Unit
    Examples:
      | company         |
      | CompanyPosition |

  Scenario Outline: TCR-33 Crear un position
    Given se tiene el company '<company>' y el organizational unit '<organizationalUnit>'
    And el usuario hace clic en la opción de New Position
    When llena el formulario del position con los siguientes valores:
      | Field       | Value     |
      | name        | Position1 |
      | displayName | Position1 |
      | description | Position1 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el position
    Examples:
      | company         | organizationalUnit |
      | CompanyPosition | OU-Position        |

  Scenario Outline: TCR-34 Editar un position
    Given se tiene el company '<company>' y el organizational unit '<organizationalUnit>'
    When  el usuario hace clic en el botón de editar para el position '<position>' seleccionado
    And   realiza la edición del formulario del position con los siguientes valores:
      | Field       | Nuevo valor |
      | name        | Position2   |
      | displayName | Position2   |
      | description | Position2   |
    Then se muestra un mensaje confirmando la edición exitosa del position
    Examples:
      | company         | organizationalUnit | position  |
      | CompanyPosition | OU-Position        | Position1 |

  Scenario Outline: TCR-35 Eliminar un position
    Given se tiene el company '<company>' y el organizational unit '<organizationalUnit>'
    When  el usuario hace clic derecho en el position '<position>'
    And   hace clic en la opción Delete Position
    Then  se muestra un mensaje confirmando que se ha eliminado el Position
    Examples:
      | company         | organizationalUnit | position  |
      | CompanyPosition | OU-Position        | Position2 |


  Scenario Outline: Eliminar Organizational Unit
    Given se tiene el company '<company>' y el usuario hace click derecho en el organizational unit '<organizationalUnit>'
    When  el usuario hace click derecho en la opción Delete Organizational Unit
    Then  se muestra un mensaje confirmando que se ha eliminado el Organizational Unit
    Examples:
      | company         | organizationalUnit |
      | CompanyPosition | OU-Position        |

  Scenario Outline: Eliminar company
    Given el usuario hace click derecho en el company '<company>'
    When  el usuario hace click en la opción Delete Company
    Then  se muestra un mensaje confirmando que se ha eliminado el company
    Examples:
      | company         |
      | CompanyPosition |