Feature: Probar el ciclo de vida del componente release

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager

  Scenario: TCR-04 Crear Release
    Given se crea un proyecto que permita usar release:
      | Field       | Value        |
      | name        | Project07151 |
      | displayName | Project07151 |
      | description | Project07151 |
      | startDay    | 20           |
      | endDay      | 25           |
      | endYear     | 2025         |
      | state       | Open         |
      | useProject  | true         |
      | useReleases | true         |
    When hace clic en el botón de Nueva Liberación
    And llena el formulario de release con los siguientes valores:
      | Field            | Value          |
      | name             | ReleaseQ3.2025 |
      | displayName      | ReleaseQ3.2025 |
      | description      | ReleaseQ3.2025 |
      | startDateRelease | 20-03-2023     |
      | endDateRelease   | 25-03-2025     |
      | idRelease        | R1             |
      | stateRelease     | Open           |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el release

  Scenario Outline: TCR-05 Editar Release
    Given se tiene el proyecto '<project>' y el release '<release>' creado
    When el usuario realiza la edición del release existente con los siguientes valores:
      | Field       | Value          |
      | name        | ReleaseQ4.2025 |
      | displayName | ReleaseQ4.2025 |
      | description | ReleaseQ4.2025 |
    Then se muestra un mensaje confirmando la edición exitosa
    Examples:
      | project      | release        |
      | Project07151 | ReleaseQ3.2025 |

  Scenario Outline: TCR-06 Eliminar Release
    Given se tiene el proyecto '<project>' y el release '<release>' creado
    When el usuario elimina el release '<release>' y el proyecto '<project>' existente
    Then se muestra un mensaje confirmando la eliminación del release
    Examples:
      | project      | release        |
      | Project07151 | ReleaseQ4.2025 |
