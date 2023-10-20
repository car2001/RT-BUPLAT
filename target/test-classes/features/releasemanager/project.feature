
Feature: Probar el ciclo de vida del componente del proyecto

  Background: El usuario ha iniciado sesión
    Given el usuario ha iniciado sesión y esta en la aplicación Release Manager

  Scenario: Crear Proyecto
    When el usuario hace clic derecho en Proyectos
    And  el usuario hace click en Nuevo Proyecto
    And  llena todos los campos requeridos
    And  hace clic en el botón de guardar
    Then se muestra un mensaje confirmando que se ha creado el proyecto