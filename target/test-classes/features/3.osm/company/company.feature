Feature: Probar el ciclo de vida del componente Company

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: TCR-25 Crear un Company
    Given el usuario hace click en la opción New Company
    When  llena el formulario del company con los siguientes valores:
      | Field       | Value    |
      | name        | Cucumber |
      | displayName | Cucumber |
      | description | Cucumber |
      | taxNumber   | TX-25    |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el company

  Scenario Outline: TCR-26 Editar un Company
    Given el usuario selecciona el company '<company>'
    When  hace clic en el botón de editar para el company seleccionado
    And   realiza la edición del formulario del company con los siguientes valores actualizados:
      | Field       | Nuevo valor |
      | name        | Cucumber51  |
      | displayName | Cucumber51  |
      | description | Cucumber51  |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el company
    Examples:
      | company  |
      | Cucumber |

  Scenario Outline: TCR-27 Ver dependencias de un Company
    Given el usuario selecciona el company '<company>'
    When  el usuario hace click en el botón de ver dependencias del company
    Then  se muestra la tabla con la lista de dependencias del company
    Examples:
      | company  |
      | Cucumber51 |

  Scenario Outline: TCR-28 Eliminar un Company
    Given el usuario hace click derecho en el company '<company>'
    When  el usuario hace click en la opción Delete Company
    Then  se muestra un mensaje confirmando que se ha eliminado el company
    Examples:
      | company  |
      | Cucumber51 |

