package org.example.ejed;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Scene;

/**
 * La clase HelloController gestiona la lógica de la interfaz de usuario para la aplicación de manejo de personas.
 * Se encarga de la interacción con la tabla de personas, así como de la adición de nuevas personas mediante una ventana modal.
 */
public class HelloController {

    @FXML
    private TableView<Persona> tableView;  // Tabla de personas
    @FXML
    private TableColumn<Persona, String> nombreColumn;  // Columna Nombre
    @FXML
    private TableColumn<Persona, String> apellidosColumn;  // Columna Apellidos
    @FXML
    private TableColumn<Persona, Integer> edadColumn;  // Columna Edad
    @FXML
    private Button agregarButton;  // Botón para agregar personas

    private ObservableList<Persona> personas;  // Lista observable de personas

    /**
     * Inicializa el controlador. Se llama automáticamente al cargar el FXML.
     * Configura las columnas de la tabla y asigna la acción al botón agregar.
     */
    @FXML
    public void initialize() {
        personas = FXCollections.observableArrayList();
        tableView.setItems(personas);

        // Configuración de las columnas de la tabla
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        apellidosColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        edadColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());

        // Asignar la acción al botón agregar
        agregarButton.setOnAction(e -> agregarPersona());
    }

    /**
     * Abre una ventana modal para agregar una nueva persona.
     * Carga el archivo FXML correspondiente y espera a que se cierre la ventana.
     */
    private void agregarPersona() {
        try {
            // Cargar el FXML de la ventana modal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana modal
            NuevaPersonaController controller = loader.getController();
            controller.setParentController(this); // Establecer el controlador padre

            // Crear la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Nueva Persona");
            stage.setScene(new Scene(root));
            stage.setResizable(false); // No se puede cambiar el tamaño
            stage.initModality(Modality.APPLICATION_MODAL); // Modalidad
            stage.showAndWait(); // Esperar a que se cierre la ventana

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la ventana de agregar persona.");
        }
    }

    /**
     * Agrega una nueva persona a la lista si no existe.
     *
     * @param nuevaPersona La persona a agregar.
     */
    public void agregarPersona(Persona nuevaPersona) {
        if (!personas.contains(nuevaPersona)) {
            personas.add(nuevaPersona);
            mostrarAlerta("Éxito", "Persona agregada con éxito.");
        } else {
            mostrarAlerta("Error", "Esta persona ya existe en la lista.");
        }
    }

    /**
     * Muestra una alerta en la interfaz de usuario.
     *
     * @param titulo El título de la alerta.
     * @param mensaje El mensaje a mostrar en la alerta.
     */
    public void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
