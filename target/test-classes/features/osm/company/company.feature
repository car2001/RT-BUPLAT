Feature: Probar el ciclo de vida del componente Company

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager

  Scenario: TCR-25 Crear un Company
    Given el usuario hace click en la opción New Company
    When llena el formulario del company con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
      | taxNumber   | NameProject |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Company

  Scenario: TCR-26 Editar un Company
    Given el usuario selecciona el "Company"
    When hace clic en el botón de editar para el "Company" seleccionado
    And realiza la edición del formulario del "Company" con los siguientes valores actualizados:
      | Field       | Nuevo valor   |
      | name        | CC-7151-mod   |
      | displayName | CC-7151-mod   |
      | description | CC-7151-mod   |
      | taxNumber   | NewTaxNumber  |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el "Company"

  Scenario: TCR-27 Ver dependencias de un Company
    Given el usuario selecciona el "Company"
    When el usuario hace click en el botón de ver dependencias
    Then se muestra la tabla con la lista de dependencias

  Scenario: TCR-28 Eliminar un Company
    Given el usuario hace click derecho en el "Company"
    When el usuario hace click en la opción Delete Company
    Then se muestra un mensaje confirmando que se ha eliminado el "Company"

