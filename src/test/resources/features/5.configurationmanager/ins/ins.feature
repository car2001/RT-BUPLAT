Feature: Probar el ciclo de vida del componente Instance Numbering Schema

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Configuration Manager
    When el usuario selecciona la opción Instance Numbering Schema en el menú lateral

  Scenario: TCR-51 Crear un Instance Numbering Schema
    Given el usuario hace clic en el botón de agregar un Instance Numbering Schema
    When llena el formulario del Instance Numbering Schema con los siguientes valores:
      | Field         | Value          |
      | name          | SchemaCucumber |
      | displayName   | SchemaCucumber |
      | description   | SchemaCucumber |
      | separator     | -              |
      | componentType | FixedValue     |
      | value         | INS            |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Instance Numbering Schema

  Scenario Outline: TCR-52 Editar un Instance Numbering Schema
    Given el usuario selecciona el Instance Numbering Schema '<ins>' de la lista y hace clic en el botón de editar
    When llena el formulario del Instance Numbering Schema con los siguientes valores actualizados:
      | Field       | Value           |
      | name        | SchemaCucumber2 |
      | displayName | SchemaCucumber2 |
      | description | SchemaCucumber2 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el Instance Numbering Schema
    Examples:
      | ins            |
      | SchemaCucumber |

  Scenario Outline: TCR-53 Eliminar un Instance Numbering Schema
    When el usuario hace clic en el botón de eliminar del Instance Numbering Schema '<ins>'
    Then se muestra un mensaje confirmando la eliminación del Instance Numbering Schema
    Examples:
      | ins             |
      | SchemaCucumber2 |

