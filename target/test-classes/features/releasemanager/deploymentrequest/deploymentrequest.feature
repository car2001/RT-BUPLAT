Feature: Probar el ciclo de vida del componente Deployment Request

  Background:
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager

  Scenario: TCR-13 Crear un Deployment Request desde el árbol.
    Given el usuario hace click en la opción New Deployment Package
    When llena el formulario del deployment package con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
      | project     | NameProject |
      | release     | NameRelease |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el Deployment Package

  Scenario: TCR-14 Crear un Deployment Package desde la tabla.
    Given el usuario hace click en el botón de agregar de la tabla de Deployment Packages
    When llena el formulario del deployment package con los siguientes valores:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
      | project     | NameProject |
      | release     | NameRelease |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el deployment package

  Scenario: TCR-15 Editar un Deployment Package desde el árbol.
    Given el usuario hace click al "Change Container" existente desde el árbol y hace hace click en el botón editar
    When realiza la edición del formulario del "Change Container" con los siguientes valores actualizados:
      | Field       | Value       |
      | name        | CC-7151     |
      | displayName | CC-7151     |
      | description | CC-7151     |
      | project     | NameProject |
      | release     | NameRelease |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el deployment package

  Scenario: TCR-16 Editar un Deployment Package desde la tabla.
    Given el usuario selecciona al "Deployment Package" desde la tabla y hace hace click en el botón editar
    When realiza la edición del formulario del "Change Container" con los siguientes valores actualizados:
      | Field       | Nuevo valor |
      | name        | CC-7151-mod |
      | displayName | CC-7151-mod |
      | description | CC-7151-mod |
      | project     | NewProject  |
      | release     | NewRelease  |
      | owner       | newTester   |
    And hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha editado el change container

  Scenario: TCR-17 Eliminar Deployment Package desde el árbol
    Given el usuario realiza clic derecho en el "Deployment Package" desde el árbol
    When selecciona la opción "Delete Deployment Package"
    Then se muestra un mensaje confirmando que se ha eliminado el "Deployment Package"

  Scenario: TCR-18 Eliminar Deployment Package desde la tabla
    Given el usuario selecciona el "Deployment Package" desde la tabla
    When hace clic en el botón de eliminar
    Then se muestra un mensaje confirmando que se ha eliminado el "Deployment Package"
