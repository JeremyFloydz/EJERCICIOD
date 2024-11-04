module org.example.ejed {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejed to javafx.fxml;
    exports org.example.ejed;
}