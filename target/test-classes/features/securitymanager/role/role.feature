Feature: Probar el ciclo de vida del componente Role

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Security Manager
    When el usuario selecciona la opción Role en el menú lateral

  Scenario: TCR-39 Crear un Role
    Given el usuario hace click en el botón de Agregar
    When llena el formulario del role con los siguientes valores:
      | Field         | Value   |
      | name          | CC-7151 |
      | displayName   | CC-7151 |
      | description   | CC-7151 |
      | useAttributes | false   |
      | isComposite   | false   |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el role

  Scenario: TCR-40 Editar un Role
    Given el usuario selecciona el role de la lista de Roles y hace click en el botón de editar
    When llena el formulario del role con los siguientes valores:
      | Field         | Value   |
      | name          | CC-7151 |
      | displayName   | CC-7151 |
      | description   | CC-7151 |
      | useAttributes | false   |
      | isComposite   | false   |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el role

  Scenario: TCR-41 Eliminar un Role
    Given el usuario selecciona el role que desea eliminar de la lista de Roles
    When hace clic en el botón de eliminar del Role
    Then se muestra un mensaje confirmando la eliminación del role