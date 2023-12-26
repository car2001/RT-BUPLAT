Feature: Probar el ciclo de vida del componente del proyecto

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager

  Scenario: TCR-01 Crear Proyecto
    When el usuario hace click en Nuevo Proyecto
    And llena el formulario de proyecto con los siguientes valores:
      | Campo       | Valor         |
      | name        | ProjectDevops |
      | displayName | ProjectDevops |
      | description | ProjectDevops |
      | startDay    | 20            |
      | endDay      | 25            |
      | endYear     | 2025          |
      | state       | Open          |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el proyecto

  Scenario Outline: TCR-02 Editar Proyecto
    When el usuario hace click en el proyecto '<project>' para editarlo
    And hace clic en el botón editar y se editan los campos del formulario con los siguientes valores:
      | Campo       | Valor          |
      | name        | ProjectDevops2 |
      | displayName | ProjectDevops2 |
      | description | ProjectDevops2 |
    Then se muestra un mensaje confirmando que se ha editado el proyecto
    Examples:
      | project       |
      | ProjectDevops |

  Scenario Outline: TCR-03 Eliminar Proyecto
    When el usuario hace click en el proyecto '<project>' para eliminar
    And hace clic en el botón eliminar
    Then se muestra un mensaje confirmando que se ha eliminado el proyecto
    Examples:
      | project        |
      | ProjectDevops2 |

  Scenario Outline: TCR-04 Verificar que se genere la carpeta Release dentro un proyecto.
    When
