package org.example.urbanmap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Establecer la conexión con la base de datos
        ConexionBD.conectar();
        
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 780);
        
        // Cargar todos los CSS necesarios
        scene.getStylesheets().add(HelloApplication.class.getResource("navBar.css").toExternalForm());
        scene.getStylesheets().add(HelloApplication.class.getResource("mainView.css").toExternalForm());
        scene.getStylesheets().add(HelloApplication.class.getResource("propertyDetail.css").toExternalForm());
        
        stage.setTitle("UrbanMap");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
        
        // Cerrar la conexión al cerrar la aplicación
        stage.setOnCloseRequest(event -> ConexionBD.desconectar());
    }

    public static void main(String[] args) {
        launch();
    }
}