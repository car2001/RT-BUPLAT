Feature: Probar el ciclo de vida del componente Deployment Package
  Para poder probar este ciclo de vida se debe tener un proyecto y un release creados.


  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager

  Scenario: Crear proyecto y release.
    Given se crea un proyecto que permita usar release:
      | Field       | Value  |
      | name        | TestDP |
      | displayName | TestDP |
      | description | TestDP |
      | startDay    | 20     |
      | endDay      | 25     |
      | endYear     | 2025   |
      | state       | Open   |
      | useProject  | true   |
      | useReleases | true   |
    When hace clic en el botón de Nueva Liberación
    And llena el formulario de release con los siguientes valores:
      | Field            | Value      |
      | name             | RDP2025    |
      | displayName      | RDP2025    |
      | description      | RDP2025    |
      | startDateRelease | 20-03-2023 |
      | endDateRelease   | 25-04-2025 |
      | idRelease        | R1         |
      | stateRelease     | Open       |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el release

  Scenario: TCR-13 Crear un Deployment Package desde el árbol
    Given el usuario hace click en la opción New Deployment Package
    When llena el formulario del deployment package con los siguientes valores:
      | Field       | Value   |
      | displayName | DP-7151 |
      | description | DP-7151 |
      | project     | TestDP  |
      | release     | RDP2025 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Deployment Package

  Scenario: TCR-14 Crear un Deployment Package desde la tabla
    Given el usuario hace click en el botón de agregar de la tabla de Deployment Packages
    When  llena el formulario del deployment package con los siguientes valores:
      | Field       | Value   |
      | displayName | DP-7454 |
      | description | DP-7454 |
      | project     | TestDP  |
      | release     | RDP2025 |
    And  hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Deployment Package desde la tabla

  Scenario Outline: TCR-15 Editar un Deployment Package desde el árbol
    Given el usuario hace click al '<DeploymentPackage>' existente desde el árbol y hace hace click en el botón editar
    When realiza la edición del formulario del deployment package con los siguientes valores actualizados:
      | Field       | Value       |
      | displayName | DP-7151-mod |
      | description | DP-7151-mod |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el deployment package
    Examples:
      | DeploymentPackage |
      | DP-7151           |

  Scenario Outline: TCR-16 Editar un Deployment Package desde la tabla
    Given el usuario selecciona al '<DeploymentPackage>' desde la tabla y hace hace click en el botón editar
    When realiza la edición del formulario del deployment package con los siguientes valores actualizados:
      | Field       | Nuevo valor |
      | displayName | DP-7454-mod |
      | description | DP-7454-mod |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el deployment package desde la tabla
    Examples:
      | DeploymentPackage |
      | DP-7454           |

  Scenario Outline: TCR-17 Eliminar Deployment Package desde el árbol
    Given el usuario realiza clic derecho en el deployment package '<DeploymentPackage>' desde el árbol
    When selecciona la opción Delete Deployment Package
    Then se muestra un mensaje confirmando que se ha eliminado el deployment package del árbol
    Examples:
      | DeploymentPackage |
      | DP-7151-mod       |

  Scenario Outline: TCR-18 Eliminar Deployment Package desde la tabla
    Given el usuario selecciona el deployment package '<DeploymentPackage>' desde la tabla
    When hace clic en el botón de eliminar de la tabla Deployment Packages
    Then se muestra un mensaje confirmando que se ha eliminado el deployment package de la tabla
    Examples:
      | DeploymentPackage |
      | DP-7454-mod       |

  Scenario Outline: Eliminar proyecto y release.
    Given se tiene el proyecto '<project>' y el release '<release>' creado
    When el usuario elimina el release '<release>' y el proyecto '<project>' existente
    Then se muestra un mensaje confirmando la eliminación del release
    Examples:
      | project | release |
      | TestDP  | RDP2025 |

