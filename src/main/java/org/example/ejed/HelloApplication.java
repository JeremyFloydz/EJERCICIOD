package org.example.ejed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase HelloApplication es la clase principal de la aplicación JavaFX.
 * Extiende la clase {@link Application} y proporciona el punto de entrada para la aplicación.
 */
public class HelloApplication extends Application {

    /**
     * Este método se invoca al iniciar la aplicación.
     * Carga el archivo FXML, establece el ícono de la ventana y crea la escena.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si no se puede cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Cargar y establecer el ícono de la ventana
        Image icon = new Image(getClass().getResourceAsStream("/img/agenda.png"));
        stage.getIcons().add(icon);

        // Crear la escena con las dimensiones adecuadas
        Scene scene = new Scene(fxmlLoader.load(), 734, 474);

        // Establecer el título de la ventana
        stage.setTitle("Personas");

        // Mostrar la escena en la ventana
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        // Iniciar la aplicación
        launch();
    }
}
