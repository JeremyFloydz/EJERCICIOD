package org.example.ejed;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

/**
 * Controlador para la ventana de creación de una nueva persona.
 * Permite ingresar los datos de una persona y guardarlos.
 */
public class NuevaPersonaController {
    @FXML
    private TextField nombreField; // Campo de nombre
    @FXML
    private TextField apellidosField; // Campo de apellidos
    @FXML
    private TextField edadField; // Campo de edad
    @FXML
    private Button guardarButton; // Botón para guardar
    @FXML
    private Button cancelarButton; // Botón para cancelar

    private HelloController parentController; // Controlador padre

    /**
     * Método que se ejecuta al inicializar el controlador.
     * Asigna las acciones a los botones de guardar y cancelar.
     */
    @FXML
    public void initialize() {
        // Asignar acción al botón de guardar
        guardarButton.setOnAction(e -> guardarPersona());
        // Asignar acción al botón de cancelar
        cancelarButton.setOnAction(e -> cancelar());
    }

    /**
     * Establece el controlador padre para este controlador.
     *
     * @param parentController El controlador padre que manejará la lista de personas.
     */
    public void setParentController(HelloController parentController) {
        this.parentController = parentController;
    }

    /**
     * Método para guardar los datos de la nueva persona.
     * Valida los campos y añade la nueva persona al controlador padre.
     */
    private void guardarPersona() {
        // Obtener datos de los campos
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        int edad;

        // Validación de los datos
        if (nombre.isEmpty() || apellidos.isEmpty() || edadField.getText().isEmpty()) {
            mostrarAlerta("Error", "Por favor, completa todos los campos.");
            return;
        }

        try {
            edad = Integer.parseInt(edadField.getText()); // Convertir a entero

            // Crear la nueva persona y agregarla al controlador padre
            Persona nuevaPersona = new Persona(nombre, apellidos, edad);
            parentController.agregarPersona(nuevaPersona); // Agregar a la lista del controlador padre

            // Cerrar la ventana
            Stage stage = (Stage) guardarButton.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            // Manejar error de conversión a entero
            mostrarAlerta("Error", "La edad debe ser un número válido.");
        }
    }

    /**
     * Método para cancelar la creación de la nueva persona.
     * Cierra la ventana sin guardar los datos.
     */
    private void cancelar() {
        // Cerrar la ventana sin hacer nada
        Stage stage = (Stage) cancelarButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Método para mostrar alertas al usuario.
     *
     * @param titulo   El título de la alerta.
     * @param mensaje  El mensaje a mostrar en la alerta.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
