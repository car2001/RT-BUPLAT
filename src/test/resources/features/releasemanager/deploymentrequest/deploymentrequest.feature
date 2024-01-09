Feature: Probar el ciclo de vida del componente Deployment Request
  Para poder probar este ciclo de vida se debe tener un proyecto y un release creados.

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager

  Scenario: Crear proyecto y release.
    Given se crea un proyecto que permita usar release:
      | Field       | Value  |
      | name        | TestDR |
      | displayName | TestDR |
      | description | TestDR |
      | startDay    | 20     |
      | endDay      | 25     |
      | endYear     | 2025   |
      | state       | Open   |
      | useProject  | true   |
      | useReleases | true   |
    When hace clic en el botón de Nueva Liberación
    And llena el formulario de release con los siguientes valores:
      | Field            | Value      |
      | name             | RDR2025    |
      | displayName      | RDR2025    |
      | description      | RDP2025    |
      | startDateRelease | 20-03-2023 |
      | endDateRelease   | 25-04-2025 |
      | idRelease        | R1         |
      | stateRelease     | Open       |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el release

  Scenario: TCR-19 Crear un Deployment Request desde el árbol
    Given el usuario hace click en la opción New Deployment Request
    When llena el formulario del deployment request con los siguientes valores:
      | Field       | Value   |
      | displayName | DR-7151 |
      | description | DR-7151 |
      | project     | TestDR  |
      | release     | RDR2025 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el deployment request

  Scenario: TCR-20 Crear un Deployment Request desde la tabla
    Given el usuario hace click en el botón de agregar de la tabla de Deployment Request
    When llena el formulario del deployment request con los siguientes valores:
      | Field       | Value   |
      | displayName | DR-7454 |
      | description | DR-7454 |
      | project     | TestDR  |
      | release     | RDR2025 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el deployment request

  Scenario Outline: TCR-21 Editar un Deployment Request desde el árbol
    Given el usuario hace click en el deployment request '<DeploymentRequest>' desde el árbol y hace hace click en el botón editar
    When realiza la edición del formulario del deployment request con los siguientes valores actualizados:
      | Field       | Value       |
      | displayName | DR-7151-mod |
      | description | DR-7151-mod |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el deployment request desde el árbol
    Examples:
      | DeploymentRequest |
      | DR-7151           |

  Scenario Outline: TCR-22 Editar un Deployment Request desde la tabla
    Given el usuario selecciona el deployment request '<DeploymentRequest>' desde la tabla y hace hace click en el botón editar
    When realiza la edición del formulario del deployment request con los siguientes valores actualizados:
      | Field       | Nuevo valor |
      | displayName | DR-7454-mod |
      | description | DR-7454-mod |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el deployment request desde la tabla
    Examples:
      | DeploymentRequest |
      | DR-7454           |

  Scenario Outline: TCR-23 Eliminar un Deployment Request desde el árbol
    Given el usuario realiza clic derecho en el deployment request '<DeploymentRequest>' desde el árbol
    When selecciona la opción Delete Deployment Request
    Then se muestra un mensaje confirmando que se ha eliminado el deployment request del árbol
    Examples:
      | DeploymentRequest |
      | DR-7151-mod       |

  Scenario Outline: TCR-24 Eliminar un Deployment Request desde la tabla
    Given el usuario selecciona el deployment request '<DeploymentRequest>' desde la tabla
    When hace clic en el botón de eliminar
    Then se muestra un mensaje confirmando que se ha eliminado el deployment request de la tabla
    Examples:
      | DeploymentRequest |
      | DR-7454-mod       |


  Scenario Outline: Eliminar proyecto y release.
    Given se tiene el proyecto '<project>' y el release '<release>' creado
    When el usuario elimina el release '<release>' y el proyecto '<project>' existente
    Then se muestra un mensaje confirmando la eliminación del release
    Examples:
      | project | release |
      | TestDR  | RDR2025 |