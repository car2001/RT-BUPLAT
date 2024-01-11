Feature: Probar el ciclo de vida del componente User

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Security Manager
    When el usuario selecciona la opción User en el menú lateral

  Scenario: TCR-45 Crear un User
    Given el usuario hace click en el botón de Agregar
    When llena el formulario del User Group con los siguientes valores:
      | Field       | Value   |
      | name        | CC-7151 |
      | displayName | CC-7151 |
      | description | CC-7151 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el User Group

  Scenario: TCR-46 Editar un User
    Given el usuario selecciona el User Group de la lista de Grupo de Usuarios y hace click en el botón de editar
    When llena el formulario del role con los siguientes valores:
      | Field       | Value   |
      | name        | CC-7151 |
      | displayName | CC-7151 |
      | description | CC-7151 |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el User Group

  Scenario: TCR-47 Eliminar un User
    Given el usuario selecciona el User Group que desea eliminar de la lista de Grupo de Usuarios
    When hace clic en el botón de eliminar del User Group
    Then se muestra un mensaje confirmando la eliminación el User Group