Feature: Probar el ciclo de vida del componente Organizational Unit
  Para poder probar este ciclo de vida se debe tener un company creado.

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: Crear company
    Given el usuario hace click en la opción New Company
    When  llena el formulario del company con los siguientes valores:
      | Field       | Value                     |
      | name        | CompanyOrganizationalUnit |
      | displayName | CompanyOrganizationalUnit |
      | description | CompanyOrganizationalUnit |
      | taxNumber   | TX-25                     |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el company

  Scenario Outline: TCR-29 Crear un Organizational Unit
    Given se tiene el company '<company>' y hace clic en la opción de New Organizational Unit
    When  llena el formulario de organizational unit con los siguientes valores:
      | Field       | Value                   |
      | name        | OrganizationalUnitAdmin |
      | displayName | OrganizationalUnitAdmin |
      | description | OrganizationalUnitAdmin |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Organizational Unit
    Examples:
      | company                   |
      | CompanyOrganizationalUnit |

  Scenario Outline: TCR-30 Editar un Organizational Unit
    Given se tiene el company '<company>' y el usuario selecciona el organizational unit '<organizationalUnit>'
    When  el usuario hace clic en el botón de editar para el organizational unit seleccionado
    And   realiza la edición del formulario del Organizational Unit con los siguientes valores:
      | Field       | Value                    |
      | name        | OrganizationalUnitAdmin2 |
      | displayName | OrganizationalUnitAdmin2 |
      | description | OrganizationalUnitAdmin2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el Organizational Unit
    Examples:
      | company                   | organizationalUnit      |
      | CompanyOrganizationalUnit | OrganizationalUnitAdmin |

  Scenario Outline: TCR-31 Ver dependencias de un Organizational Unit
    Given se tiene el company '<company>' y el usuario selecciona el organizational unit '<organizationalUnit>'
    When  el usuario hace click en el botón de ver dependencias del Organizational Unit
    Then  se muestra la tabla con la lista de dependencias asociadas al Organizational Unit
    Examples:
      | company                   | organizationalUnit      |
      | CompanyOrganizationalUnit | OrganizationalUnitAdmin2 |

  Scenario Outline: TCR-32 Eliminar un Organizational Unit
    Given se tiene el company '<company>' y el usuario hace click derecho en el organizational unit '<organizationalUnit>'
    When  el usuario hace click derecho en la opción Delete Organizational Unit
    Then  se muestra un mensaje confirmando que se ha eliminado el Organizational Unit
    Examples:
      | company                   | organizationalUnit       |
      | CompanyOrganizationalUnit | OrganizationalUnitAdmin2 |

  Scenario Outline: Eliminar company
    Given el usuario hace click derecho en el company '<company>'
    When  el usuario hace click en la opción Delete Company
    Then  se muestra un mensaje confirmando que se ha eliminado el company
    Examples:
      | company  |
      | CompanyOrganizationalUnit |