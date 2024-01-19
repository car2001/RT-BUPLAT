Feature: Probar el ciclo de vida del componente User
  Para poder probar este Feature es necesario tener un company, orgUnit y position creados

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Security Manager
    When el usuario selecciona la opción User en el menú lateral

  Scenario: TCR-45 Crear un User
    Given el usuario hace click en el botón de Agregar un user
    When llena el formulario del user con los siguientes valores:
      | Field           | Value                 |
      | userName        | cperez2               |
      | password        | 1234                  |
      | email           | cperez2@wedox.co      |
      | startDate       | 20-04-2023            |
      | endDate         | 10-07-2025            |
      | name            | Carlos                |
      | lastName        | Perez                 |
      | company         | WEDOX Empresa         |
      | orgUnit         | Desarrollo Software   |
      | position        | Desarrollador Backend |
      | licenseCategory | End User              |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el usuario

  Scenario Outline: TCR-46 Editar un User
    Given el usuario selecciona el user '<user>' de la lista de usuarios y hace click en el botón de editar
    When llena el formulario del user con los siguientes valores actualizados:
      | Field    | Value   |
      | name     | Carlos2 |
      | lastName | Perez2  |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el usuario
    Examples:
      | user    |
      | cperez2 |

  Scenario Outline: TCR-47 Eliminar un User
    When el usuario hace clic en el botón de eliminar del user '<user>'
    Then se muestra un mensaje confirmando la eliminación del user
    Examples:
      | user    |
      | cperez2 |