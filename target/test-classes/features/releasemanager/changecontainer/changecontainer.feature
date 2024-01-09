Feature: Probar el ciclo de vida del componente Change Container
  Para poder probar este ciclo de vida se debe tener un proyecto y un release creados.

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager


  Scenario: Crear proyecto y release.
    Given se crea un proyecto que permita usar release:
      | Field       | Value               |
      | name        | TestChangeContainer |
      | displayName | TestChangeContainer |
      | description | TestChangeContainer |
      | startDay    | 20                  |
      | endDay      | 25                  |
      | endYear     | 2025                |
      | state       | Open                |
      | useProject  | true                |
      | useReleases | true                |
    When hace clic en el botón de Nueva Liberación
    And llena el formulario de release con los siguientes valores:
      | Field            | Value         |
      | name             | ReleaseCC2023 |
      | displayName      | ReleaseCC2023 |
      | description      | ReleaseCC2023 |
      | startDateRelease | 20-03-2023    |
      | endDateRelease   | 25-04-2025    |
      | idRelease        | R1            |
      | stateRelease     | Open          |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el release

  Scenario: TCR-07 Crear change container desde el árbol
    Given el usuario hace click en la opción New Change Container
    When llena el formulario del change container con los siguientes valores:
      | Field       | Value               |
      | name        | CC-7151             |
      | displayName | CC-7151             |
      | description | CC-7151             |
      | project     | TestChangeContainer |
      | release     | ReleaseCC2023       |
      | owner       | tester              |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el change container


  Scenario: TCR-08 Crear change container desde la tabla
    Given el usuario hace click en el botón de agregar de la tabla de Change Containers
    When llena el formulario del change container con los siguientes valores:
      | Field       | Value               |
      | name        | CC-7454             |
      | displayName | CC-7454             |
      | description | CC-7454             |
      | project     | TestChangeContainer |
      | release     | ReleaseCC2023       |
      | owner       | tester              |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el change container

  Scenario Outline: TCR-09 Editar change container desde el árbol
    Given el usuario selecciona el '<ChangeContainer>' existente desde el árbol y hace hace click en el botón editar
    When realiza la edición del formulario del change container con los siguientes valores actualizados:
      | Field       | Nuevo valor |
      | name        | CC-7151-mod |
      | displayName | CC-7151-mod |
      | description | CC-7151-mod |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el change container
    Examples:
      | ChangeContainer |
      | CC-7151         |


  Scenario Outline: TCR-10 Editar change container desde la tabla
    Given el usuario selecciona el '<ChangeContainer>' desde la tabla y hace hace click en el botón editar
    When realiza la edición del formulario del change container con los siguientes valores actualizados:
      | Field       | Nuevo valor |
      | name        | CC-7454-mod |
      | displayName | CC-7454-mod |
      | description | CC-7454-mod |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el change container
    Examples:
      | ChangeContainer |
      | CC-7454         |

  Scenario Outline: TCR-11 Eliminar change container desde el árbol
    Given el usuario realiza clic derecho en el '<ChangeContainer>' desde el árbol
    When selecciona la opción Delete Change Container
    Then se muestra un mensaje confirmando que se ha eliminado el change container del árbol
    Examples:
      | ChangeContainer |
      | CC-7151-mod     |

  Scenario Outline: TCR-12 Eliminar change container desde la tabla
    Given el usuario selecciona el '<ChangeContainer>' desde la tabla
    When hace clic en el botón de eliminar de la tabla de Change Containers
    Then se muestra un mensaje confirmando que se ha eliminado el change container de la tabla
    Examples:
      | ChangeContainer |
      | CC-7454-mod     |


  Scenario Outline: Eliminar proyecto y release.
    Given se tiene el proyecto '<project>' y el release '<release>' creado
    When el usuario elimina el release '<release>' y el proyecto '<project>' existente
    Then se muestra un mensaje confirmando la eliminación del release
    Examples:
      | project             | release       |
      | TestChangeContainer | ReleaseCC2023 |
